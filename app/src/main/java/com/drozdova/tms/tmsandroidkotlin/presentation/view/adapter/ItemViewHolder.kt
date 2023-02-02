package com.drozdova.tms.tmsandroidkotlin.presentation.view.adapter

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.drozdova.tms.tmsandroidkotlin.databinding.ItemBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.view.listener.ItemListener
import com.drozdova.tms.tmsandroidkotlin.model.Item
import com.squareup.picasso.Picasso

class ItemViewHolder(
    private val view : ItemBinding,
    private val itemListener: ItemListener
) : ViewHolder(view.root) {

    fun bind(item : Item) {
        view.itemTitle.text = item.description
        Picasso.get().load(Uri.parse(item.image)).into(view.itemImage)

        view.itemImage.setOnClickListener {
            itemListener.imageClick()
        }

        itemView.setOnClickListener {
            itemListener.itemDetailsClick(item.description, item.image)
        }

        view.delete.setOnClickListener {
            itemListener.onDeleteClick(item.description)
        }

        view.fav.setOnClickListener{
            itemListener.onFavClicked(item.description)
        }
    }
}