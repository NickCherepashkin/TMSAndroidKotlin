package com.drozdova.tms.tmsandroidkotlin.presentation.view.home.items.adapter

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import com.drozdova.tms.tmsandroidkotlin.databinding.FavouriteItemBinding
import com.drozdova.tms.tmsandroidkotlin.model.FavouriteModel
import com.squareup.picasso.Picasso

class FavouriteViewHolder(
    private val view : FavouriteItemBinding
) : RecyclerView.ViewHolder(view.root) {
    fun bind(favItem : FavouriteModel) {
        view.itemTitle.text = favItem.description
        Picasso.get().load(Uri.parse(favItem.image)).into(view.itemImage)
    }
}