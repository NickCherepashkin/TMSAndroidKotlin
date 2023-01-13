package com.drozdova.tms.tmsandroidkotlin.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.presentation.view.adapter.ItemsAdapter
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentItemsBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.view.listener.ItemListener
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.ItemsViewModel
import com.drozdova.tms.tmsandroidkotlin.utils.BundleConstants
import com.drozdova.tms.tmsandroidkotlin.utils.NavHelper.navigate
import com.drozdova.tms.tmsandroidkotlin.utils.NavHelper.navigateWithBundle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemsFragment : Fragment(), ItemListener {
    private var _binding : FragmentItemsBinding? = null
    val binding get() = _binding!!

    private val viewModel : ItemsViewModel by viewModels()

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

        adapter = ItemsAdapter(this)
        binding.rvItemsList.adapter = adapter

        viewModel.getItemslist()

        viewModel.itemsList.observe(viewLifecycleOwner) { list ->
            adapter.submit(list)
        }

        viewModel.bundle.observe(viewLifecycleOwner) { item ->
            if (item != null) {
                val bundle = Bundle()
                bundle.putString(BundleConstants.NAME_KEY, item.title)
                bundle.putString(BundleConstants.DATE_KEY, item.date)
                bundle.putInt(BundleConstants.IMAGE_KEY, item.image)

                navigateWithBundle(item.destination, bundle)
            }
        }

        viewModel.msg.observe(viewLifecycleOwner) {message ->
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun itemDetailsClick(name: String, date: String, image: Int) {
        viewModel.itemDetailsClick(name, date, image)
    }

    override fun imageClick() {
        viewModel.imageClick()
    }
}