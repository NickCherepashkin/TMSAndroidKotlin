package com.drozdova.tms.tmsandroidkotlin.data.items

import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.model.Item
import com.drozdova.tms.tmsandroidkotlin.domain.repository.ItemsRepository
import javax.inject.Inject

class ItemsRepositoryImpl @Inject constructor() : ItemsRepository {
    override fun getItemsList() : List<Item> {
        val listItems = listOf(
            Item(
                R.drawable.android,
                "Android",
                "26.02.2022"
            ),
            Item(
                R.drawable.apple,
                "IOS",
                "26.02.2022"
            ),
            Item(
                R.drawable.dot_net,
                ".Net",
                "26.02.2022"
            ),
            Item(
                R.drawable.delphi,
                "Delphi",
                "26.02.2022"
            ),
            Item(
                R.drawable.java,
                "Java",
                "26.02.2022"
            ),
            Item(
                R.drawable.python,
                "Python",
                "26.02.2022"
            ),
            Item(
                R.drawable.js,
                "Java Script",
                "26.02.2022"
            ),
            Item(
                R.drawable.android,
                "Android",
                "26.02.2022"
            ),
            Item(
                R.drawable.apple,
                "IOS",
                "26.02.2022"
            )
        )
        return listItems
    }
}