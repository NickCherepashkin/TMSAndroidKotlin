package com.drozdova.tms.tmsandroidkotlin.presentation.view.home.items

import android.Manifest
import android.content.Context.LOCATION_SERVICE
import android.content.pm.PackageManager
import android.location.LocationListener
import android.location.LocationManager
import android.location.LocationManager.GPS_PROVIDER
import android.location.LocationManager.NETWORK_PROVIDER
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.getSystemService
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentFavouriteBinding
import com.drozdova.tms.tmsandroidkotlin.databinding.FragmentItemsBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.view.home.items.adapter.FavouriteViewAdapter
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.FavouriteItemsViewModel
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.ItemsViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception

@AndroidEntryPoint
class FavouriteFragment : Fragment() {

    private var _binding : FragmentFavouriteBinding? = null
    val binding get() = _binding!!

    private val viewModel : FavouriteItemsViewModel by viewModels()

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

        favAdapter = FavouriteViewAdapter()
        binding.rvFavItemsList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFavItemsList.adapter = favAdapter

        viewModel.getFav()

        viewModel.fav.observe(viewLifecycleOwner) {favList ->
            favAdapter.submit(favList)
        }

        var locationMmanager: LocationManager? = null

        locationMmanager = requireActivity().getSystemService(LOCATION_SERVICE) as LocationManager?

        try {
            if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                return
            }
            locationMmanager?.requestLocationUpdates(
                    NETWORK_PROVIDER,
                    0L,
                    0f,
                    locationListener
            )
        } catch (e: Exception) {

        }
    }

    private val locationListener = LocationListener{

        Toast.makeText(requireContext(), "Long: ${it.longitude} lat ${it.latitude}", Toast.LENGTH_LONG).show()
    }

}