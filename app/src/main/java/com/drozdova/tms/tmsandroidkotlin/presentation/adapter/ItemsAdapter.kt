package com.drozdova.tms.tmsandroidkotlin.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drozdova.tms.tmsandroidkotlin.presentation.model.Item
import com.drozdova.tms.tmsandroidkotlin.databinding.ItemBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.listener.ItemsListener

class ItemsAdapter(private val itemsListener: ItemsListener) : RecyclerView.Adapter<ItemViewHolder>() {
    private var itemsList = mutableListOf<Item>()

    fun submit(itemsList: List<Item>) {
        this.itemsList.clear()
        this.itemsList = itemsList.toMutableList()
        this.notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(view, itemsListener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemsList[position])
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}