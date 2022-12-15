package com.drozdova.tms.tmsandroidkotlin.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.presentation.view.fragments.LoginFragment
import com.drozdova.tms.tmsandroidkotlin.presentation.view.fragments.OnBoardingFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = supportFragmentManager.beginTransaction()
        fragment.add(R.id.fragments_container, LoginFragment())
                .commit()
    }
}