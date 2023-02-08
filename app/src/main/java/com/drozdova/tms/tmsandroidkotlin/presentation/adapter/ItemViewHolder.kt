package com.drozdova.tms.tmsandroidkotlin.presentation.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.data.model.UserInfo
import com.drozdova.tms.tmsandroidkotlin.presentation.model.Item
import com.drozdova.tms.tmsandroidkotlin.databinding.ItemBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.listener.ItemsListener
import com.drozdova.tms.tmsandroidkotlin.presentation.model.User
import java.text.SimpleDateFormat
import java.util.*

class ItemViewHolder(
    private val view: ItemBinding,
    private val itemsListener: ItemsListener
) : ViewHolder(view.root) {
    fun bind(user : User) {
        view.itemId.text = user.id.toString()
        view.itemTitle.text = "${user.name} ${user.username}"
        view.itemDate.text = "contacts: ${user.email}, ${user.phone}"
        view.itemImageFav.isSelected = user.favorite

        view.itemImageFav.setOnClickListener {
            view.itemImageFav.isSelected = !it.isSelected
            itemsListener.onFavClicked(user.id)
        }

        itemView.setOnClickListener {
            itemsListener.showItemDetails(
                user.name,
                user.username,
                0
            )
        }

        view.itemImageDelete.setOnClickListener() {
            itemsListener.deleteItem(user.id)
        }
    }
}