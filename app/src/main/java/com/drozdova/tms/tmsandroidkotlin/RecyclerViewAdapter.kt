package com.drozdova.tms.tmsandroidkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.FruitViewHolder>() {

    private var listFruits : List<String>? = null

    class FruitViewHolder(view: View): ViewHolder(view) {
        val etTitle = view.findViewById<TextView>(R.id.et_fruit_title)

        fun bind(fruitTitle: String) {
            etTitle.text = fruitTitle
        }
    }

    fun setListData(listFruits: List<String>?) {
        this.listFruits = listFruits
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruit_item, parent, false)
        return FruitViewHolder(view)
    }

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        holder.bind(listFruits?.get(position)!!)
    }

    override fun getItemCount(): Int {
        if (listFruits == null) return 0
        return listFruits?.size!!
    }
}