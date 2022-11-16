package com.drozdova.tms.tmsandroidkotlin

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import com.drozdova.tms.tmsandroidkotlin.MainActivity2.Companion.goToActivity2

class MainActivity : AppCompatActivity() {
    lateinit var et : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = getString(R.string.activity_title_1)

        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.green)))

        et = findViewById(R.id.edit_text)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        menu?.setGroupVisible(R.id.menu_a2, false)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_open_a2 -> goToActivity2(this)
            R.id.menu_set_in_act_bar -> {
                val text: String = et.text.toString()
                goToActivity2(this, text)
            }
            R.id.menu_unblock -> {
                if (et.isEnabled) {
                    item.title = getString(R.string.menu_unblock)
                    et.isEnabled = false
                } else {
                    item.title = getString(R.string.menu_block)
                    et.isEnabled = true
                }
            }

            R.id.menu_close -> finishAffinity()
        }
        return super.onOptionsItemSelected(item)
    }
}