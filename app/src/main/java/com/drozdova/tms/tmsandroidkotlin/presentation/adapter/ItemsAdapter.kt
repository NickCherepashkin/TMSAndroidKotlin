package com.drozdova.tms.tmsandroidkotlin.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.databinding.ListItemBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.adapter.listener.ItemListener
import com.drozdova.tms.tmsandroidkotlin.model.ItemsModel

class ItemsAdapter(
    private val itemsListener: ItemListener
): RecyclerView.Adapter<ItemsViewHolder>() {

    private var listItems = mutableListOf<ItemsModel>()

    fun submitList(listItems: List<ItemsModel>) {
        this.listItems = listItems.toMutableList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val viewBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemsViewHolder(viewBinding, itemsListener)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int {
        if (listItems == null) return 0
        return listItems?.size!!
    }
}