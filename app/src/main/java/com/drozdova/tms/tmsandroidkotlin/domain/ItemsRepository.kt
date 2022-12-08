package com.drozdova.tms.tmsandroidkotlin.domain

import com.drozdova.tms.tmsandroidkotlin.model.ItemsModel

interface ItemsRepository {
    fun getData() : List<ItemsModel>
}