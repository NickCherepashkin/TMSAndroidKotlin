package com.drozdova.tms.tmsandroidkotlin.data.items

import android.util.Log
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.data.ApiService
import com.drozdova.tms.tmsandroidkotlin.data.ApiServiceSecond
import com.drozdova.tms.tmsandroidkotlin.data.database.ItemsEntity
import com.drozdova.tms.tmsandroidkotlin.data.database.dao.ItemsDAO
import com.drozdova.tms.tmsandroidkotlin.model.Item
import com.drozdova.tms.tmsandroidkotlin.domain.repository.ItemsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import javax.inject.Inject
import javax.inject.Named

class ItemsRepositoryImpl @Inject constructor(
    @Named("FIRST") private val apiService: ApiService,
    @Named("SECOND") private val apiServiceSecond: ApiServiceSecond,
    private val itemsDAO: ItemsDAO
) : ItemsRepository {
    override suspend fun getData() {
        return withContext(Dispatchers.IO) {
            if (!itemsDAO.doesItemsEntityExists()) {
                Log.w("getData", "data not exists")
                val response = apiService.getData()
                response.body()?.sampleList?.let {
                    it.map {
                        val itemssEntity = ItemsEntity((1..999).random(), it.description, it.imageUrl)
                        itemsDAO.insertItemsEntity(itemssEntity)
                    }
                } ?: kotlin.run {
                    emptyList()
                }
            }
        }
    }

    override suspend fun showData(): List<Item> {
        return withContext(Dispatchers.IO){
            val itemsEntity = itemsDAO.getItemsEntity()
            itemsEntity.map {
                Item(it.description, it.imageUrl)
            }
        }
    }

    override suspend fun deleteItemByDescription(description: String) {
        withContext(Dispatchers.IO) {
            itemsDAO.deleteItemByDescription(description)
        }
    }

    override suspend fun findItemByDescription(searchText: String): Item {
        return withContext(Dispatchers.IO){
            Item("","")
//            val itemEntity = itemsDAO.findItemEntityByDescription(searchText)
        }
    }
}