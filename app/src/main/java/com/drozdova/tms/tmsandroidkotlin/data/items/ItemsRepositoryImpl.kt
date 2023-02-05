package com.drozdova.tms.tmsandroidkotlin.data.items

import android.util.Log
import com.drozdova.tms.tmsandroidkotlin.R
import com.drozdova.tms.tmsandroidkotlin.data.ApiService
import com.drozdova.tms.tmsandroidkotlin.data.ApiServiceSecond
import com.drozdova.tms.tmsandroidkotlin.data.database.FavEntity
import com.drozdova.tms.tmsandroidkotlin.data.database.ItemsEntity
import com.drozdova.tms.tmsandroidkotlin.data.database.dao.ItemsDAO
import com.drozdova.tms.tmsandroidkotlin.model.Item
import com.drozdova.tms.tmsandroidkotlin.domain.repository.ItemsRepository
import com.drozdova.tms.tmsandroidkotlin.model.FavouriteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
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
                val response = apiService.getData()
                Log.w("getData", response.body()?.sampleList.toString())
                response.body()?.sampleList?.let {
                    Log.w("SIZE...", "SIZE = ${it.size.toString()}")
                    it.map {
                        val itemssEntity = ItemsEntity(it.description, it.imageUrl)
                        itemsDAO.insertItemsEntity(itemssEntity)
                    }
                } ?: kotlin.run {
                    emptyList()
                }
            }
        }
    }

    override suspend fun showData(): Flow<List<Item>>  {
        return withContext(Dispatchers.IO){
            val itemsEntity = itemsDAO.getItemsEntity()
            itemsEntity.map {itemsList ->
                itemsList.map {item ->
                    Item(item.description, item.imageUrl)
                }
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
            val itemEntity = itemsDAO.findItemEntityByDescription(searchText)
            Item(itemEntity.description, itemEntity.imageUrl)
        }
    }

    override suspend fun favClicked(description: String) {
        return withContext(Dispatchers.IO) {
            val itemEntity = itemsDAO.findItemEntityByDescription(description)
            itemsDAO.insertFavEntity(
                FavEntity(itemEntity.description, itemEntity.imageUrl)
            )
        }
    }

    override suspend fun getFavourite(): List<FavouriteModel> {
        return withContext(Dispatchers.IO) {
            val favsEntity = itemsDAO.getFavEntities()
            favsEntity.map {
                FavouriteModel(it.description, it.imageUrl)
            }
        }
    }
}