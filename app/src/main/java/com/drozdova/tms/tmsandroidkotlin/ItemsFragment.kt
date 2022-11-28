package com.drozdova.tms.tmsandroidkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsFragment : Fragment() {
    private lateinit var rvFruitAdapter : RecyclerViewAdapter
//    private lateinit var binding:

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listFruits = listOf<String>("Orange", "Banana", "Kiwi", "Apple", "Watermelon")

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_fruits)
        recyclerView.apply {
            recyclerView.layoutManager = LinearLayoutManager(activity)
            rvFruitAdapter = RecyclerViewAdapter()
            recyclerView.adapter = rvFruitAdapter
            rvFruitAdapter.setListData(listFruits)
        }


    }
}