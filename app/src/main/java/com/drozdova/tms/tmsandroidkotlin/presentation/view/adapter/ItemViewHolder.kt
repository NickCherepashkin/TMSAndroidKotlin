package com.drozdova.tms.tmsandroidkotlin.presentation.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding
import com.drozdova.tms.tmsandroidkotlin.data.model.Item
import com.drozdova.tms.tmsandroidkotlin.databinding.ItemBinding
import java.util.Calendar

class ItemViewHolder(private val view: ItemBinding) : ViewHolder(view.root) {
    fun bind(item : Item) {
        view.itemImage.setBackgroundResource(item.image)
        view.itemTitle.text = item.title
        view.itemDate.text = Calendar.getInstance().time.toString()
    }
}