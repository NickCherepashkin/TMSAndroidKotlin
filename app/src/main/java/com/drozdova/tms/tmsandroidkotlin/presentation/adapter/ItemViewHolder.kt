package com.drozdova.tms.tmsandroidkotlin.presentation.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.data.model.UserInfo
import com.drozdova.tms.tmsandroidkotlin.presentation.model.Item
import com.drozdova.tms.tmsandroidkotlin.databinding.ItemBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.listener.ItemsListener
import java.text.SimpleDateFormat
import java.util.*

private const val DATE_FORMAT = "hh:mm:ss a"

class ItemViewHolder(
    private val view: ItemBinding,
    private val itemsListener: ItemsListener
) : ViewHolder(view.root) {
    fun bind(item : UserInfo) {
        var isSelected = false
        view.itemImage.setBackgroundResource(0)
        view.itemTitle.text = item.name
        view.itemDate.text = SimpleDateFormat(DATE_FORMAT, Locale.ENGLISH).format(Date())
        view.itemImageStar.setBackgroundResource(R.drawable.black_star)

        view.itemImageStar.setOnClickListener {
            isSelected = if (!isSelected) {
                view.itemImageStar.setBackgroundResource(R.drawable.yellow_star)
                true

            } else {
                view.itemImageStar.setBackgroundResource(R.drawable.black_star)
                false
            }
            itemsListener.isItemSelected(isSelected)
        }

        itemView.setOnClickListener {
            itemsListener.showItemDetails(
                item.name,
                item.username,
                0
            )
        }
    }
}