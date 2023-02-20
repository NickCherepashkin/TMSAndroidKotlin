package com.drozdova.tms.tmsandroidkotlin.presentation.view.home.items

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentFavouriteBinding
import com.drozdova.tms.tmsandroidkotlin.App
import com.drozdova.tms.tmsandroidkotlin.presentation.receiver.AirplaneModeChangeReceiver
import com.drozdova.tms.tmsandroidkotlin.presentation.receiver.MyBroadcastReceiver
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

        val receiver = AirplaneModeChangeReceiver()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            requireContext().registerReceiver(receiver, it)
        }

        val receiver2 = MyBroadcastReceiver()
        IntentFilter("MY_ACTION").also {
            requireContext().registerReceiver(receiver2, it)
        }

        setMessage()

        favAdapter = FavouriteViewAdapter()
        binding.rvFavItemsList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFavItemsList.adapter = favAdapter

        viewModel.getFav()

        viewModel.fav.observe(viewLifecycleOwner) {favList ->
            favAdapter.submit(favList)
        }
    }

    private fun setMessage(){
        val intent = Intent("MY_ACTION")
        intent.putExtra("KEY", "message")
        requireContext().sendBroadcast(intent)
    }
}