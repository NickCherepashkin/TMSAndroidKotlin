package com.drozdova.tms.tmsandroidkotlin.data.database.dao

import android.content.ClipDescription
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.drozdova.tms.tmsandroidkotlin.data.database.FavEntity
import com.drozdova.tms.tmsandroidkotlin.data.database.ItemsEntity
import com.drozdova.tms.tmsandroidkotlin.model.Item
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemsDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItemsEntity(itemsEntity: ItemsEntity)

    @Query("Select * from ItemsEntity")
    fun getItemsEntity(): Observable<List<ItemsEntity>>

    @Query("Select(Select COUNT(*) from ItemsEntity) != 0" )
    fun doesItemsEntityExists(): Observable<Boolean>

    @Query("Delete from ItemsEntity where description = :description")
    fun deleteItemByDescription(description: String)

    @Query("SELECT * FROM ItemsEntity where description = :searchText")
    fun findItemEntityByDescription(searchText: String): ItemsEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavEntity(favEntity: FavEntity)

    @Query("SELECT * FROM favEntity")
    fun getFavEntities(): List<FavEntity>
}