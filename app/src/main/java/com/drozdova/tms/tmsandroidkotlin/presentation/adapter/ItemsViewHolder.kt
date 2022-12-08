package com.drozdova.tms.tmsandroidkotlin.presentation.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.databinding.ListItemBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.adapter.listener.ItemListener
import com.drozdova.tms.tmsandroidkotlin.model.ItemsModel

class ItemsViewHolder(
    private val viewBinding: ListItemBinding,
    private val itemsListener: ItemListener
    ) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(item: ItemsModel) {
        viewBinding.einstein.setBackgroundResource(item.image)
        viewBinding.etItemTitle.text = item.name
        viewBinding.etDate.text = item.date

        viewBinding.einstein.setOnClickListener {
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