package com.drozdova.tms.tmsandroidkotlin.data.items

import com.drozdova.tms.tmsandroidkotlin.data.ApiService
import com.drozdova.tms.tmsandroidkotlin.data.database.FavouriteEntity
import com.drozdova.tms.tmsandroidkotlin.data.database.UsersEntity
import com.drozdova.tms.tmsandroidkotlin.data.database.dao.UsersDAO
import com.drozdova.tms.tmsandroidkotlin.domain.items.ItemsRepository
import com.drozdova.tms.tmsandroidkotlin.presentation.model.FavUser
import com.drozdova.tms.tmsandroidkotlin.presentation.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ItemsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val usersDAO: UsersDAO
): ItemsRepository {
    override suspend fun getData(){
        return withContext(Dispatchers.IO) {
            if (!usersDAO.doesUsersEntityExists()) {
                val response = apiService.getData()
                response.body()?.let {
                    it.map {user ->
                        val users = UsersEntity(user.id, user.name, user.username, user.email, user.phone)
                        usersDAO.insertUserEntity(users)
                    }
                } ?: kotlin.run { emptyList() }
            }
        }
    }

    override suspend fun favClicked(id: Int): Boolean {
        return withContext(Dispatchers.IO){
            val findFavUser = usersDAO.findFavUserById(id)

            if (findFavUser == null) {
                return@withContext false
            } else {
                val usersEntity = usersDAO.findUserById(id)
                usersDAO.insertFavEntity(
                    FavouriteEntity(usersEntity.id, usersEntity.name, usersEntity.username,
                        usersEntity.email, usersEntity.phone)
                )
                return@withContext true
            }

        }
    }
    override suspend fun showData(): List<User> {
        return withContext(Dispatchers.IO){
            val usersEntity = usersDAO.getUsersEntity()
            usersEntity.map {
                User(it.id, it.name, it.username, it.email, it.phone)
            }
        }
    }

    override suspend fun findUserById(id: Int): User {
        return withContext(Dispatchers.IO){
            val user = usersDAO.findUserById(id)
            User(user.id, user.name, user.username, user.email, user.phone)
        }
    }

    override suspend fun getFavourites(): List<FavUser> {
        return withContext(Dispatchers.IO) {
            val favEntity = usersDAO.getFavouritesEntities()
            favEntity.map {
                FavUser(it.id, it.name, it.username, it.email, it.phone)
            }
        }
    }

}