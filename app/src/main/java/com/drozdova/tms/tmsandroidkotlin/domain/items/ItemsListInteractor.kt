package com.drozdova.tms.tmsandroidkotlin.domain.items

import com.drozdova.tms.tmsandroidkotlin.data.model.UserInfo
import com.drozdova.tms.tmsandroidkotlin.presentation.model.FavUser
import com.drozdova.tms.tmsandroidkotlin.presentation.model.Item
import com.drozdova.tms.tmsandroidkotlin.presentation.model.User
import javax.inject.Inject

class ItemsListInteractor @Inject constructor(private val itemsRepository: ItemsRepository) {
    suspend fun getData(){
        itemsRepository.getData()
    }

    suspend fun onFavClicked(id: Int) : Boolean{
        return itemsRepository.favClicked(id)
    }

    suspend fun showData(): List<User> {
        return itemsRepository.showData()
    }

    suspend fun showFavData(): List<FavUser> {
        return itemsRepository.getFavourites()
    }

//    suspend fun deleteItemByDescription(description: String) {
//        itemsRepository.deleteItemByDescription(description)
//    }

//    suspend fun findItem(searchText: String): Item{
//        return itemsRepository.findItemByDescription(searchText)
//    }
}