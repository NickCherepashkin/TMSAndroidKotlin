package com.drozdova.tms.tmsandroidkotlin.domain.items

import com.drozdova.tms.tmsandroidkotlin.presentation.model.FavUser
import com.drozdova.tms.tmsandroidkotlin.presentation.model.User

interface ItemsRepository {
    suspend fun getData()
    suspend fun showData(): List<User>
    suspend fun favClicked(id: Int)
    suspend fun findUserById(id: Int): User
    suspend fun getFavourites(): List<FavUser>
}