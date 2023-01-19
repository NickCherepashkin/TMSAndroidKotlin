package com.drozdova.tms.tmsandroidkotlin.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.MainPresenter
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.MainView
import com.drozdova.tms.tmsandroidkotlin.presentation.view.auth.LoginFragment
import com.drozdova.tms.tmsandroidkotlin.presentation.view.home.HomeFragment
import com.drozdova.tms.tmsandroidkotlin.utils.NavHelper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainView, NavController.OnDestinationChangedListener {

    @Inject lateinit var presenter : MainPresenter
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        presenter.setMainView(this)
        presenter.setStartScreen()
    }

    override fun setStartScreen(destination: Int) {
        val navGraf = navHostFragment.navController.navInflater.inflate(R.navigation.auth_graph)
        navGraf.setStartDestination(destination)
        navController.setGraph(destination)
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {

    }
}