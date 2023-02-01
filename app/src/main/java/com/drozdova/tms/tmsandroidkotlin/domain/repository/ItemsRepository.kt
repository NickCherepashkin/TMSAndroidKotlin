package com.drozdova.tms.tmsandroidkotlin.domain.repository

import com.drozdova.tms.tmsandroidkotlin.model.FavouriteModel
import com.drozdova.tms.tmsandroidkotlin.model.Item
import kotlinx.coroutines.flow.Flow

interface ItemsRepository {
    suspend fun getData()
    suspend fun showData(): Flow<List<Item>>
    suspend fun deleteItemByDescription(description: String)
    suspend fun findItemByDescription(searchText: String): Item
    suspend fun favClicked(description: String)
    suspend fun getFavourite(): List<FavouriteModel>
}