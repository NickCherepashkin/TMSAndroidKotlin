package com.drozdova.tms.tmsandroidkotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tv2 = findViewById<TextView>(R.id.textView2)
        val data: String = intent.getStringExtra(KEY) ?: "no data"
        tv2.text = data
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home ->onBackPressed()
            R.id.close -> finishAffinity()
            R.id.goBack -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    companion object {

        private const val KEY = "1"

        fun startMainActivity2(context: Context, data: String) {
            val intent = Intent(context, MainActivity2::class.java)
            intent.putExtra(KEY, data)
            context.startActivity(intent)
        }
    }
}