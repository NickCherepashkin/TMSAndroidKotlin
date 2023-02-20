package com.drozdova.tms.tmsandroidkotlin.presentation.view.home.items

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentItemsBinding
import com.drozdova.tms.tmsandroidkotlin.App
import com.drozdova.tms.tmsandroidkotlin.presentation.view.adapter.ItemsAdapter
import com.drozdova.tms.tmsandroidkotlin.presentation.view.listener.ItemListener
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.ItemsViewModel
import com.drozdova.tms.tmsandroidkotlin.utils.BaseFragment
import com.drozdova.tms.tmsandroidkotlin.utils.BundleConstants
import com.drozdova.tms.tmsandroidkotlin.utils.NavHelper.navigateWithBundle
import kotlinx.coroutines.flow.catch


class ItemsFragment : BaseFragment(), ItemListener {
    private var _binding : FragmentItemsBinding? = null
    val binding get() = _binding!!

    private val viewModel : ItemsViewModel by viewModels{viewModelFactory}

    private lateinit var adapter: ItemsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity().applicationContext as App).appComponent.inject(this)

        adapter = ItemsAdapter(this)
        binding.rvItemsList.adapter = adapter

        Log.w("SIZE observe...", "SIZE = getData()")


        // Способ 1
//        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
//            viewModel.getData.collect()
//        }

        // Способ 2
//        viewModel.getData()
//        viewModel.triger.observe(viewLifecycleOwner){
//            viewLifecycleOwner.lifecycleScope.launchWhenResumed {
//                it.collect()
//            }
//        }

//        viewModel.getData()

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.items.catch {
                Toast.makeText(context, it.message.toString(), Toast.LENGTH_SHORT).show()
            }.collect{ flowList ->
                flowList.collect{ list ->
                    adapter.submit(list)
                }
            }
        }

        viewModel.bundle.observe(viewLifecycleOwner) { item ->
            if (item != null) {
                val bundle = Bundle()
                bundle.putString(BundleConstants.NAME_KEY, item.description)
                bundle.putString(BundleConstants.DATE_KEY, item.image)

                navigateWithBundle(item.destination, bundle)
                viewModel.onItemsBack()
            }
        }

        viewModel.msg.observe(viewLifecycleOwner) {message ->
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }

        viewModel.error.observe(viewLifecycleOwner) {error ->
            Log.w("ERROR_LOAD", error.toString())
            Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
        }

    }

    override fun itemDetailsClick(description: String, image: String) {
        viewModel.itemDetailsClick(description, image)
    }

    override fun imageClick() {
        viewModel.imageClick()
    }

    override fun onDeleteClick(description: String) {
        viewModel.deleteItem(description)
    }

    override fun onFavClicked(description: String) {
        viewModel.onFavClicked(description)
    }
}