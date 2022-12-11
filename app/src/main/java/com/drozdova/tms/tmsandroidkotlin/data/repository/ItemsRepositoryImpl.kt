package com.drozdova.tms.tmsandroidkotlin.data.repository

import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.data.model.Item
import com.drozdova.tms.tmsandroidkotlin.domain.repository.ItemsRepository

class ItemsRepositoryImpl: ItemsRepository {
    override fun getData() : List<Item> {
        val list = listOf(
            Item(R.drawable.hh, "Hip-hop", "it is cool dance style",""),
            Item(R.drawable.contemp, "Contemporary", "it is cool dance style",""),
            Item(R.drawable.krump, "Krump", "it is cool dance style",""),
            Item(R.drawable.locking, "Locking", "it is cool dance style",""),
            Item(R.drawable.house, "House", "it is cool dance style",""),
            Item(R.drawable.belly, "Belly", "it is cool dance style",""),
            Item(R.drawable.break_dance, "Break dance", "it is cool dance style",""),
            Item(R.drawable.house, "House", "it is cool dance style",""),
            Item(R.drawable.hh, "Hip-hop", "it is cool dance style",""),
            Item(R.drawable.locking, "Locking", "it is cool dance style",""),
            Item(R.drawable.krump, "Krump", "it is cool dance style","")
        )
        return list
    }
}