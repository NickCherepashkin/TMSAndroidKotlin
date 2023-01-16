package com.drozdova.tms.tmsandroidkotlin.presentation.view.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentItemsListBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.adapter.ItemsAdapter
import com.drozdova.tms.tmsandroidkotlin.presentation.listener.ItemsListener
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.ItemsListViewModel
import com.drozdova.tms.tmsandroidkotlin.utils.BundleConstants
import com.drozdova.tms.tmsandroidkotlin.utils.ErrorMessages
import com.drozdova.tms.tmsandroidkotlin.utils.NavHelper.navigateWithBundle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemsListFragment : Fragment(), ItemsListener {
    private var _bindingList : FragmentItemsListBinding? = null
    val bindingList get() = _bindingList!!

    private lateinit var adapter: ItemsAdapter

    private val viewModel: ItemsListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _bindingList = FragmentItemsListBinding.inflate(inflater, container, false)
        return bindingList.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ItemsAdapter(this)
        bindingList.recViewList.adapter = adapter
        bindingList.recViewList.layoutManager = LinearLayoutManager(context)

        viewModel.getData()

        viewModel.itemsList.observe(viewLifecycleOwner) { list ->
            adapter.submit(list)
        }

        viewModel.bundle.observe(viewLifecycleOwner) { item ->
            if (item != null) {
                val bundle = Bundle()

                bundle.putString(BundleConstants.ITEM_NAME, item.title)
                bundle.putString(BundleConstants.ITEM_DATE, item.date)
                bundle.putInt(BundleConstants.ITEM_IMAGE, item.image)

                navigateWithBundle(item.destination, bundle)
                viewModel.onItemsBack()
            }
        }

        viewModel.msg.observe(viewLifecycleOwner) { message ->
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }

        viewModel.msgError.observe(viewLifecycleOwner) { error->
            AlertDialog.Builder(context)
                .setTitle(ErrorMessages.WARNING)
                .setMessage(error)
                .setCancelable(false)
                .setNegativeButton("cancel") {dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }

    override fun isItemSelected(isSelect : Boolean) {
        val msg : String
        if (isSelect) {
            msg = getString(R.string.checked_txt)
        } else {
            msg = getString(R.string.not_checked_txt)
        }
        viewModel.imageClick(msg)
    }

    override fun showItemDetails(name: String, date: String, imageView: Int) {
        viewModel.goToDetails(name, date, imageView)
    }
}