package com.drozdova.tms.tmsandroidkotlin.presentation.view.home.items

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentFavouriteBinding
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentItemsBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.view.home.items.adapter.FavouriteViewAdapter
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.FavouriteItemsViewModel
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.ItemsViewModel


class FavouriteFragment : Fragment() {

    private var _binding : FragmentFavouriteBinding? = null
    val binding get() = _binding!!

    private val viewModel : FavouriteItemsViewModel by viewModels()

    private lateinit var favAdapter: FavouriteViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favAdapter = FavouriteViewAdapter()
        binding.rvFavItemsList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFavItemsList.adapter = favAdapter

        viewModel.fav.observe(viewLifecycleOwner) {

        }

    }


}