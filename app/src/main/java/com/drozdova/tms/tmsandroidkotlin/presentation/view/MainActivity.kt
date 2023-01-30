package com.drozdova.tms.tmsandroidkotlin.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.databinding.ActivityMainBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.MainPresenter
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.MainView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainView{
    private lateinit var binding: ActivityMainBinding

    @Inject lateinit var presenter : MainPresenter
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)

        presenter.setMainView(this)
        presenter.setStartScreen()
    }

    override fun setStartScreen(destination: Int) {
        navController.setGraph(destination)
        binding.bottomNavigationView.visibility = when(destination) {
            R.navigation.auth_graph -> View.INVISIBLE
            else -> View.VISIBLE
        }
    }
}