package com.drozdova.tms.tmsandroidkotlin.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.drozdova.tms.tmsandroidkotlin.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = supportFragmentManager.beginTransaction()
        fragment.add(R.id.fragment_container, LoginFragment())
            .commit()
    }
}