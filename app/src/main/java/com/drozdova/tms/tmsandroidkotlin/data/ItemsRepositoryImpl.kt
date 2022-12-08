package com.drozdova.tms.tmsandroidkotlin.data

import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.domain.ItemsRepository
import com.drozdova.tms.tmsandroidkotlin.model.ItemsModel

class ItemsRepositoryImpl : ItemsRepository {
    override fun getData() : List<ItemsModel> {
        val listItems = listOf(
            ItemsModel(
                R.drawable.android,
                "Android",
                "26.02.2022"
            ),
            ItemsModel(
                R.drawable.apple,
                "IOS",
                "26.02.2022"
            ),
            ItemsModel(
                R.drawable.dot_net,
                ".Net",
                "26.02.2022"
            ),
            ItemsModel(
                R.drawable.delphi,
                "Delphi",
                "26.02.2022"
            ),
            ItemsModel(
                R.drawable.java,
                "Java",
                "26.02.2022"
            ),
            ItemsModel(
                R.drawable.python,
                "Python",
                "26.02.2022"
            ),
            ItemsModel(
                R.drawable.js,
                "Java Script",
                "26.02.2022"
            ),
            ItemsModel(
                R.drawable.android,
                "Android",
                "26.02.2022"
            ),
            ItemsModel(
                R.drawable.apple,
                "IOS",
                "26.02.2022"
            )
        )
        return listItems
    }
}