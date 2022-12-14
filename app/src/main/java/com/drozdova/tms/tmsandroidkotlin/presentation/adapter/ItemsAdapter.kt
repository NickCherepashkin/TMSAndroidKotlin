package com.drozdova.tms.tmsandroidkotlin.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drozdova.tms.tmsandroidkotlin.databinding.ItemBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.listener.ItemListener
import com.drozdova.tms.tmsandroidkotlin.data.model.Item

class ItemsAdapter(private val itemsListener: ItemListener) : RecyclerView.Adapter<ItemViewHolder>() {
    private var _binding : ItemBinding? = null
    val binding get() = _binding

    private var itemsList = mutableListOf<Item>()

    fun submit(list : List<Item>) {
        itemsList = list.toMutableList()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view =ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(view, itemsListener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemsList[position])
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}