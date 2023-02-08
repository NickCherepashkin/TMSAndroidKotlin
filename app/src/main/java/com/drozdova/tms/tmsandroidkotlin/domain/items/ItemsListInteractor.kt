package com.drozdova.tms.tmsandroidkotlin.domain.items

import com.drozdova.tms.tmsandroidkotlin.data.model.UserInfo
import com.drozdova.tms.tmsandroidkotlin.presentation.model.FavUser
import com.drozdova.tms.tmsandroidkotlin.presentation.model.Item
import com.drozdova.tms.tmsandroidkotlin.presentation.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemsListInteractor @Inject constructor(private val itemsRepository: ItemsRepository) {
    suspend fun getData(){
        itemsRepository.getData()
    }

    suspend fun onFavClicked(id: Int){
        itemsRepository.favClicked(id)
    }

    suspend fun showData(): Flow<List<User>> {
        return itemsRepository.showData()
    }

    suspend fun showFavData(): List<FavUser> {
        return itemsRepository.getFavourites()
    }

    suspend fun deleteItem(id: Int) {
        itemsRepository.deleteItem(id)
    }

    suspend fun deleteFavItem(id: Int) {
        itemsRepository.deleteFavItem(id)
    }

//    suspend fun deleteItemByDescription(description: String) {
//        itemsRepository.deleteItemByDescription(description)
//    }

//    suspend fun findItem(searchText: String): Item{
//        return itemsRepository.findItemByDescription(searchText)
//    }
}