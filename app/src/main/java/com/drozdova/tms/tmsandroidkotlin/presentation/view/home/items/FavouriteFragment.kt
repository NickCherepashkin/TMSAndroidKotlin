package com.drozdova.tms.tmsandroidkotlin.presentation.view.home.items

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentFavouriteBinding
import com.drozdova.tms.tmsandroidkotlin.App
import com.drozdova.tms.tmsandroidkotlin.presentation.view.home.items.adapter.FavouriteViewAdapter
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.FavouriteItemsViewModel
import com.drozdova.tms.tmsandroidkotlin.utils.BaseFragment


class FavouriteFragment : BaseFragment() {

    private var _binding : FragmentFavouriteBinding? = null
    val binding get() = _binding!!

    private val viewModel : FavouriteItemsViewModel by viewModels{viewModelFactory}

    private lateinit var favAdapter: FavouriteViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavouriteBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity().applicationContext as App).appComponent.inject(this)

        favAdapter = FavouriteViewAdapter()
        binding.rvFavItemsList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFavItemsList.adapter = favAdapter

        viewModel.getFav()

        viewModel.fav.observe(viewLifecycleOwner) {favList ->
            favAdapter.submit(favList)
        }
    }
}