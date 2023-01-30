package com.drozdova.tms.tmsandroidkotlin.presentation.adapter

import android.provider.Settings.System.DATE_FORMAT
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.data.model.UserInfo
import com.drozdova.tms.tmsandroidkotlin.databinding.FavItemBinding
import com.drozdova.tms.tmsandroidkotlin.databinding.ItemBinding
import com.drozdova.tms.tmsandroidkotlin.presentation.listener.ItemsListener
import com.drozdova.tms.tmsandroidkotlin.presentation.model.FavUser
import java.text.SimpleDateFormat
import java.util.*

class FavouriteViewHolder(
    private val view: FavItemBinding
) : ViewHolder(view.root) {
    fun bind(user : FavUser) {
        view.favItemId.text = user.id.toString()
        view.favItemTitle.text = "${user.name} ${user.username}"
        view.favItemDate.text = "contacts: ${user.email}, ${user.phone}"

//        view.favItemImageStar.setOnClickListener {
//
//        }
    }
}