package com.drozdova.tms.tmsandroidkotlin.data.items

import android.util.Log
import com.drozdova.tms.tmsandroidkotlin.data.ApiService
import com.drozdova.tms.tmsandroidkotlin.data.ApiServiceSecond
import com.drozdova.tms.tmsandroidkotlin.data.database.FavEntity
import com.drozdova.tms.tmsandroidkotlin.data.database.ItemsEntity
import com.drozdova.tms.tmsandroidkotlin.data.database.dao.ItemsDAO
import com.drozdova.tms.tmsandroidkotlin.domain.repository.ItemsRepository
import com.drozdova.tms.tmsandroidkotlin.model.FavouriteModel
import com.drozdova.tms.tmsandroidkotlin.model.Item
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

class ItemsRepositoryImpl @Inject constructor(
    @Named("FIRST") private val apiService: ApiService,
    @Named("SECOND") private val apiServiceSecond: ApiServiceSecond,
    private val itemsDAO: ItemsDAO
) : ItemsRepository {
    override fun getData() : Completable {
        return itemsDAO.doesItemsEntityExists()
            .observeOn(Schedulers.io())
            .doAfterNext {
                if (!it) {
                    val response = apiService.getData()
                    response.subscribeOn(Schedulers.io())
                        .doAfterSuccess{
                            it.sampleList.map { item ->
                                val itemssEntity = ItemsEntity(item.description, item.imageUrl)
                                itemsDAO.insertItemsEntity(itemssEntity)
                            }
                        }
                        .doOnError {
                            Log.w("error", "when making request")
                        }
                        .ignoreElement()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe()
                }
            }
            .ignoreElements()
            .observeOn(AndroidSchedulers.mainThread())
    }






    override fun showData(): Observable<List<Item>>  {
        val itemsEntity = itemsDAO.getItemsEntity()
        return itemsEntity.subscribeOn(Schedulers.io())
            .map{
                it.map {itemsList ->
                    Item(itemsList.description, itemsList.imageUrl)
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
    }

    override suspend fun deleteItemByDescription(description: String) {
        withContext(Dispatchers.IO) {
            itemsDAO.deleteItemByDescription(description)
        }
    }

    override suspend fun findItemByDescription(searchText: String): Item {
        return withContext(Dispatchers.IO) {
            Item("", "")
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