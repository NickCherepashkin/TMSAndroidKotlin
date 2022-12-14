package com.drozdova.tms.tmsandroidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = supportFragmentManager.beginTransaction()
        fragment.add(R.id.fragments_container, OnBoardingFragment())
                .commit()
    }
}