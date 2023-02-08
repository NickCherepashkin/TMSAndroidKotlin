package com.drozdova.tms.tmsandroidkotlin.data.items

import com.drozdova.tms.tmsandroidkotlin.data.ApiService
import com.drozdova.tms.tmsandroidkotlin.data.database.FavouriteEntity
import com.drozdova.tms.tmsandroidkotlin.data.database.UsersEntity
import com.drozdova.tms.tmsandroidkotlin.data.database.dao.UsersDAO
import com.drozdova.tms.tmsandroidkotlin.domain.items.ItemsRepository
import com.drozdova.tms.tmsandroidkotlin.presentation.model.FavUser
import com.drozdova.tms.tmsandroidkotlin.presentation.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ItemsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val usersDAO: UsersDAO
): ItemsRepository {

    override suspend fun getData(){
        return withContext(Dispatchers.IO) {
            usersDAO.doesUsersEntityExists().collect{
                if (!it) {
                    val response = apiService.getData()
                    response.body()?.let {usersList ->
                        usersList.map {user ->
                            val users = UsersEntity(user.id, name = user.name, username = user.username, email = user.email, phone = user.phone, false)
                            usersDAO.insertUserEntity(users)
                        }
                    }
                }
            }
        }
    }

    override suspend fun favClicked(id: Int){
        withContext(Dispatchers.IO){
            val usersEntity = usersDAO.findUserById(id)
            if(!usersEntity.favorite) {
                usersEntity.favorite = true
                usersDAO.insertFavEntity(
                    FavouriteEntity(usersEntity.id, usersEntity.name, usersEntity.username,
                        usersEntity.email, usersEntity.phone)
                )
            } else {
                usersEntity.favorite = false
                usersDAO.deleteFavItem(id)
            }

            usersDAO.updateFavState(usersEntity)
        }
    }



    override suspend fun showData(): Flow<List<User>> {
        return  withContext(Dispatchers.IO){
            usersDAO.getUsersEntity().map {usersEntity ->
                usersEntity.map {
                    User(it.id, it.name, it.username, it.email, it.phone, it.favorite)
                }
            }
        }
    }

    override suspend fun findUserById(id: Int): User {
        return withContext(Dispatchers.IO){
            val user = usersDAO.findUserById(id)
            User(user.id, user.name, user.username, user.email, user.phone, user.favorite)
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

    override suspend fun deleteItem(id: Int) {
        withContext(Dispatchers.IO) {
            usersDAO.deleteItem(id)
        }
    }

    override suspend fun deleteFavItem(id: Int) {
        withContext(Dispatchers.IO) {
            val usersEntity = usersDAO.findUserById(id)
            usersEntity.favorite = false
            usersDAO.deleteFavItem(id)
            usersDAO.updateFavState(usersEntity)
        }
    }
}