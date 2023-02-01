package com.drozdova.tms.tmsandroidkotlin.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.drozdova.tms.tmsandroidkotlin.data.database.FavouriteEntity
import com.drozdova.tms.tmsandroidkotlin.data.database.UsersEntity
import com.drozdova.tms.tmsandroidkotlin.presentation.model.FavUser
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDAO {
    @Insert
    fun insertUserEntity(usersEntity: UsersEntity)

    @Query("Select * from users")
    fun getUsersEntity(): Flow<List<UsersEntity>>

    @Insert
    fun insertFavEntity(favouriteEntity: FavouriteEntity)

    @Query("Select(Select COUNT(*) from users) != 0")
    fun doesUsersEntityExists(): Flow<Boolean>

    @Query("Select * from users where id = :id")
    fun findUserById(id: Int): UsersEntity

    @Query("Select * from favourite where id = :id")
    fun findFavUserById(id: Int): FavUser

    @Query("SELECT * FROM favourite")
    fun getFavouritesEntities(): List<FavouriteEntity>

    @Query("DELETE FROM users where id = :id")
    fun deleteItem(id: Int)
}