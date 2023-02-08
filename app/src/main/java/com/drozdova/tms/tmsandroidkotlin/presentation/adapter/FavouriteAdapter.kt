package com.drozdova.tms.tmsandroidkotlin.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drozdova.tms.tmsandroidkotlin.data.model.UserInfo
import com.drozdova.tms.tmsandroidkotlin.databinding.FavItemBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.listener.FavItemListener
import com.drozdova.tms.tmsandroidkotlin.presentation.model.FavUser

class FavouriteAdapter(private val favItemListener: FavItemListener) : RecyclerView.Adapter<FavouriteViewHolder>() {
    private var itemsList = mutableListOf<FavUser>()

    fun submit(itemsList: List<FavUser>) {
        this.itemsList.clear()
        this.itemsList = itemsList.toMutableList()
        this.notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        val view = FavItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavouriteViewHolder(view, favItemListener)
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        holder.bind(itemsList[position])
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}