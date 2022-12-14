package com.drozdova.tms.tmsandroidkotlin.presentation.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.drozdova.tms.tmsandroidkotlin.databinding.ItemBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.listener.ItemListener
import com.drozdova.tms.tmsandroidkotlin.data.model.Item

class ItemViewHolder(
    private val view : ItemBinding,
    private val itemListener: ItemListener
) : ViewHolder(view.root) {

    fun bind(item : Item) {
        view.itemImage.setBackgroundResource(item.image)
        view.itemTitle.text = item.title
        view.itemDate.text = item.date

        view.itemImage.setOnClickListener {
            itemListener.imageClick()
        }

        itemView.setOnClickListener {
            itemListener.itemDetailsClick(item.title, item.date, item.image)
        }
    }
}