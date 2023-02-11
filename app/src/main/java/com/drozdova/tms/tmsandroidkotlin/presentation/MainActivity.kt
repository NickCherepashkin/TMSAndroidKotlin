package com.drozdova.tms.tmsandroidkotlin.presentation

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.databinding.ActivityMainBinding
import com.drozdova.tms.tmsandroidkotlin.di.App
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.MainViewModel
import javax.inject.Inject


class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {

    private lateinit var binding: ActivityMainBinding
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel : MainViewModel by viewModels{viewModelFactory}
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))

        setContentView(binding.root)

        (applicationContext as App).appComponent.inject(this)

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
}