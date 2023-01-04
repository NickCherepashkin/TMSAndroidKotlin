package com.drozdova.tms.tmsandroidkotlin.presentation.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentItemsListBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.adapter.ItemsAdapter
import com.drozdova.tms.tmsandroidkotlin.presentation.listener.ItemsListener
import com.drozdova.tms.tmsandroidkotlin.presentation.model.Item
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.ListPresenter
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.ListView
import com.drozdova.tms.tmsandroidkotlin.utils.BundleConstants
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ItemsListFragment : Fragment(), ListView, ItemsListener {
    private var _bindingList : FragmentItemsListBinding? = null
    val bindingList get() = _bindingList!!

    private lateinit var adapter: ItemsAdapter

    @Inject lateinit var presenter: ListPresenter

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

        presenter.setView(this)
        presenter.getData()
    }

    override fun setData(list: List<Item>) {
        adapter.submit(list)
    }

    override fun goToDetails(name: String, date: String, imageView: Int) {
        val detailsFragment = DetailsFragment()
        val bundle = Bundle()

        bundle.putString(BundleConstants.ITEM_NAME, name)
        bundle.putString(BundleConstants.ITEM_DATE, date)
        bundle.putInt(BundleConstants.ITEM_IMAGE, imageView)
        detailsFragment.arguments = bundle

        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, detailsFragment)
            .addToBackStack("")
            .commit()
    }

    override fun isItemSelected(isSelect : Boolean) {
        val msg : String
        if (isSelect) {
            msg = getString(R.string.checked_txt)
        } else {
            msg = getString(R.string.not_checked_txt)
        }
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    override fun showItemDetails(name: String, date: String, imageView: Int) {
        presenter.goToDetails(name, date, imageView)
    }
}