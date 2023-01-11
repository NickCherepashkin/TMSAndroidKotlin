package com.drozdova.tms.tmsandroidkotlin.domain.items

import com.drozdova.tms.tmsandroidkotlin.presentation.model.Item

interface ItemsRepository {
    suspend fun getData() : List<Item>
}