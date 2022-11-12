package com.drozdova.tms.tmsandroidkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MyActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my2)

        val btn = findViewById<Button>(R.id.btn_activity_2)

        btn.setOnClickListener {
            val intent = Intent(this, MyActivity3::class.java)
            startActivity(intent)
        }
    }
}