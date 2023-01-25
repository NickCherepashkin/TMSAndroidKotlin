package com.drozdova.tms.tmsandroidkotlin.domain.repository

import com.drozdova.tms.tmsandroidkotlin.model.Item

interface ItemsRepository {
    suspend fun getData()
    suspend fun showData(): List<Item>
    suspend fun deleteItemByDescription(description: String)
    suspend fun findItemByDescription(searchText: String): Item
}