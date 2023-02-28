package com.drozdova.tms.tmsandroidkotlin.presentation

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.databinding.ActivityMainBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.MainViewModel
import com.drozdova.tms.tmsandroidkotlin.utils.permissions.PermissionUtils
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {

    private lateinit var binding: ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))

        setContentView(binding.root)

        viewModel.userIsexist()

//        val navHostFragment = _binding!!.fragmentContainerView as NavHostFragment

        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        navController.addOnDestinationChangedListener(this)

        binding.bottomNavigationView.setupWithNavController(navController)

//        val btmNav = AppBarConfiguration(
//            setOf(R.id.homeFragment, R.id.itemsFragment)
//        )

//        NavigationUI.setupActionBarWithNavController(this,navController, btmNav)

        viewModel.userExist.observe(this) {
            navController.graph = getNavGraph()
            navController.setGraph(it)
        }

        viewModel.visibility.observe(this) {
            binding.bottomNavigationView.visibility = it
        }

    }

    private fun getNavGraph() : NavGraph{
        val navGraf = navHostFragment.navController.navInflater.inflate(
            R.navigation.auth_graph
        )

        val random = (1..5).random()
        if(random == 1) {
            navGraf.setStartDestination(R.id.loginFragment)
        } else {
            navGraf.setStartDestination(R.id.homeFragment)
        }

        return  navGraf
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        viewModel.destinationChanged(destination)
    }

    override fun onDestroy() {
        navController.removeOnDestinationChangedListener(this)
        super.onDestroy()
    }

    override fun onStart() {
        super.onStart()
        when {
            PermissionUtils.checkAccessFineLocationGranted(this) -> {
                when {
                    PermissionUtils.isLocationEnabled(this) -> {
                        setLocationListner()
                    }
                    else -> {
                        PermissionUtils.showGPSNotEnabledDialog(this)
                    }
                }
            }
            else -> {
                PermissionUtils.askAccessFineLocationPermission(
                    this,
                    42
                )
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            42 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    when {
                        PermissionUtils.isLocationEnabled(this) -> {
                            setLocationListner()
                        }
                        else -> {
                            PermissionUtils.showGPSNotEnabledDialog(this)
                        }
                    }
                } else {
                    Toast.makeText(this, "not granded permission", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setLocationListner() {
        val fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        val locationRequest = LocationRequest().setInterval(2000).setFastestInterval(2000)
            .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        fusedLocationProviderClient.requestLocationUpdates(
            locationRequest,
            object : LocationCallback() {
                override fun onLocationResult(locationResult: LocationResult) {
                    super.onLocationResult(locationResult)
                    for (location in locationResult.locations) {
                        Log.w("location", "${location.latitude} ${location.longitude}")
                    }
                }
            },
            Looper.myLooper()
        )
    }

}