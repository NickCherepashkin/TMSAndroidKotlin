package com.drozdova.tms.tmsandroidkotlin

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.drozdova.tms.tmsandroidkotlin.MainActivity2.Companion.startMainActivity2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.teal_200)))
        supportActionBar?.setIcon(R.mipmap.ic_launcher)
        supportActionBar?.title = "Add contact"


        val textView = findViewById<TextView>(R.id.text_hello)
        val btn = findViewById<Button>(R.id.button)

        btn.setOnClickListener {
            textView.text = getString(R.string.str_hello)

//            val intent = Intent(this, MainActivity2::class.java)
//            intent.putExtra("1", textView.text.toString() + " from MainActivity")
//            startActivity(intent)
            startMainActivity2(this, textView.text.toString() + "from MainActivity")

        }
    }
}