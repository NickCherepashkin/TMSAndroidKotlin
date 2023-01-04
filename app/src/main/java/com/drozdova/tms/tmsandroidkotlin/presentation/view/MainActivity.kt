package com.drozdova.tms.tmsandroidkotlin.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.presentation.view.auth.LoginFragment
import com.drozdova.tms.tmsandroidkotlin.presentation.view.home.HomeFragment
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(){

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.checkUserExists()

        viewModel.isExist.observe(this) { isExist ->
            val fragment = supportFragmentManager.beginTransaction()
            fragment.add(R.id.fragment_container,
                when(isExist) {
                    true -> HomeFragment()
                    false -> LoginFragment()
                })
                .commit()
        }
    }
}