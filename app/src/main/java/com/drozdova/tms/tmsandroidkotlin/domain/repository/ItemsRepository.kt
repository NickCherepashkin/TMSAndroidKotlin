package com.drozdova.tms.tmsandroidkotlin.domain.repository

import com.drozdova.tms.tmsandroidkotlin.data.model.Item

interface ItemsRepository {
    fun getItemsList() : List<Item>
}