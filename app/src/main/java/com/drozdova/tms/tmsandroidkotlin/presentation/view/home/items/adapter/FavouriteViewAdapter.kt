package com.drozdova.tms.tmsandroidkotlin.presentation.view.home.items.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drozdova.tms.tmsandroidkotlin.databinding.FavouriteItemBinding
import com.drozdova.tms.tmsandroidkotlin.databinding.ItemBinding
import com.drozdova.tms.tmsandroidkotlin.model.FavouriteModel
import com.drozdova.tms.tmsandroidkotlin.model.Item
import com.drozdova.tms.tmsandroidkotlin.presentation.view.adapter.ItemViewHolder
import com.drozdova.tms.tmsandroidkotlin.presentation.view.listener.ItemListener

class FavouriteViewAdapter : RecyclerView.Adapter<FavouriteViewHolder>() {
    private var _binding : FavouriteItemBinding? = null
    val binding get() = _binding

    private var itemsList = mutableListOf<FavouriteModel>()

    fun submit(list : List<FavouriteModel>) {
        itemsList.clear()
        itemsList.addAll(list.toMutableList())
        this.notifyDataSetChanged()

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        val view = FavouriteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavouriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        holder.bind(itemsList[position])
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}