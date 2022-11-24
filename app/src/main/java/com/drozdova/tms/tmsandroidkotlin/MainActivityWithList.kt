package com.drozdova.tms.tmsandroidkotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivityWithList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_with_list)

        val listView = findViewById<ListView>(R.id.listView)
        val list = listOf<String>("Apple", "Orange", "Watermelon")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        listView.adapter = adapter
    }

    companion object {
        fun startActWithList(context: Context) {
            context.startActivity(Intent(context, MainActivityWithList::class.java))
        }
    }
}