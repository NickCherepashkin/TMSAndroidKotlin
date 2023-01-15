package com.drozdova.tms.tmsandroidkotlin.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.presentation.view.auth.LoginFragment
import com.drozdova.tms.tmsandroidkotlin.presentation.view.home.HomeFragment
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(){

    private val viewModel: MainViewModel by viewModels()
    private lateinit var navFragment: NavHostFragment
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        navController = navFragment.navController

        viewModel.checkUserExists()

        viewModel.isExist.observe(this) { isExist ->
            navController.setGraph(
                isExist
            )
        }
    }
}