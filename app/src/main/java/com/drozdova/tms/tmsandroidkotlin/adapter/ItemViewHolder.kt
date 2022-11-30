package com.drozdova.tms.tmsandroidkotlin.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.listener.ItemListener
import com.drozdova.tms.tmsandroidkotlin.model.ItemModel
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

class ItemViewHolder(private val itemView: View,
                     private val listener: ItemListener): ViewHolder(itemView) {
    fun bind(item: ItemModel) {
        val imageDance = itemView.findViewById<ShapeableImageView>(R.id.imv_item)
        val tvTitle = itemView.findViewById<MaterialTextView>(R.id.tv_item_title)
        val tvTime = itemView.findViewById<MaterialTextView>(R.id.tv_item_time)
        val imageStar = itemView.findViewById<ShapeableImageView>(R.id.imv_item_star)
        var isSelect = false

        imageDance.setBackgroundResource(item.imageDance)
        tvTitle.text = item.title
        tvTime.text = Calendar.getInstance().time.toString()
        tvTime.text = SimpleDateFormat("hh:mm:ss a").format(Date())
        imageStar.setBackgroundResource(R.drawable.black_star)


        imageStar.setOnClickListener {
            if (isSelect) {
                imageStar.setBackgroundResource(R.drawable.black_star)
                isSelect = false
            } else {
                imageStar.setBackgroundResource(R.drawable.yellow_star)
                isSelect = true
            }
        }

        itemView.setOnClickListener {
            listener.onClick()
        }
    }

}