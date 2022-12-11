package com.drozdova.tms.tmsandroidkotlin.data.repository

import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.data.model.Item
import com.drozdova.tms.tmsandroidkotlin.domain.repository.ItemsRepository

class ItemsRepositoryImpl: ItemsRepository {
    override fun getData() : List<Item> {
        val list = listOf(
            Item(R.drawable.ic_launcher_background, "", "","12.23.2023"),
            Item(R.drawable.ic_launcher_background, "", "","12.23.2023"),
            Item(R.drawable.ic_launcher_background, "", "","12.23.2023"),
            Item(R.drawable.ic_launcher_background, "", "","12.23.2023"),
            Item(R.drawable.ic_launcher_background, "", "","12.23.2023"),
            Item(R.drawable.ic_launcher_background, "", "","12.23.2023"),
            Item(R.drawable.ic_launcher_background, "", "","12.23.2023"),
            Item(R.drawable.ic_launcher_background, "", "","12.23.2023"),
            Item(R.drawable.ic_launcher_background, "", "","12.23.2023"),
            Item(R.drawable.ic_launcher_background, "", "","12.23.2023"),
            Item(R.drawable.ic_launcher_background, "", "","12.23.2023")
        )
        return list
    }
}