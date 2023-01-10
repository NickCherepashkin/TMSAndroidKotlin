package com.drozdova.tms.tmsandroidkotlin.domain.repository

import com.drozdova.tms.tmsandroidkotlin.model.Item

interface ItemsRepository {
    suspend fun getItemsList() : List<Item>
}