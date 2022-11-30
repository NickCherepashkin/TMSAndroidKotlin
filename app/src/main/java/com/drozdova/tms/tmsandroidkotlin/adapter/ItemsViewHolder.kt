package com.drozdova.tms.tmsandroidkotlin.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.listener.ItemListener
import com.drozdova.tms.tmsandroidkotlin.model.ItemsModel

class ItemsViewHolder(
    private val view: View,
    private val itemsListener: ItemListener
    ) : RecyclerView.ViewHolder(view) {

    fun bind(item: ItemsModel) {
        val image = view.findViewById<ImageView>(R.id.einstein)
        val etTitle = view.findViewById<TextView>(R.id.et_item_title)
        val etDate = view.findViewById<TextView>(R.id.et_date)

        image.setBackgroundResource(item.image)
        etTitle.text = item.name
        etDate.text = item.date

        image.setOnClickListener {
            itemsListener.onClick()
        }

        itemView.setOnClickListener {
            itemsListener.onElementSelected(
                item.name,
                item.date,
                item.image
            )
        }
    }
}