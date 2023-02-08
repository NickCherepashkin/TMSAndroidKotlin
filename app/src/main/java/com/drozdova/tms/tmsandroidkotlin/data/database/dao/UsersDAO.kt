package com.drozdova.tms.tmsandroidkotlin.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.drozdova.tms.tmsandroidkotlin.data.database.FavouriteEntity
import com.drozdova.tms.tmsandroidkotlin.data.database.LoginEntity
import com.drozdova.tms.tmsandroidkotlin.data.database.UsersEntity
import com.drozdova.tms.tmsandroidkotlin.presentation.model.FavUser
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDAO {
    @Insert
    fun saveLoginUser(loginEntity: LoginEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserEntity(usersEntity: UsersEntity)

    @Query("Select * from users")
    fun getUsersEntity(): Flow<List<UsersEntity>>

    @Insert
    fun insertFavEntity(favouriteEntity: FavouriteEntity)

    @Query("Select COUNT(id) as count from users")
    fun doesUsersEntityExists(): Flow<Boolean>

    @Query("Select * from users where id = :id")
    fun findUserById(id: Int): UsersEntity

    @Query("Select * from favourite where id = :id")
    fun findFavUserById(id: Int): FavUser

    @Query("SELECT * FROM favourite")
    fun getFavouritesEntities(): List<FavouriteEntity>

    @Query("DELETE FROM users where id = :id")
    fun deleteItem(id: Int)

    @Query("DELETE FROM favourite where id = :id")
    fun deleteFavItem(id: Int)

    @Update
    fun updateFavState(usersEntity: UsersEntity)
}