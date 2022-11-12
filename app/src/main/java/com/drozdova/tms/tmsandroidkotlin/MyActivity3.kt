package com.drozdova.tms.tmsandroidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MyActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my3)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}