package com.drozdova.tms.tmsandroidkotlin.data.database.dao

import android.content.ClipDescription
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.drozdova.tms.tmsandroidkotlin.data.database.ItemsEntity
import com.drozdova.tms.tmsandroidkotlin.model.Item

@Dao
interface ItemsDAO {
    @Insert
    fun insertItemsEntity(itemsEntity: ItemsEntity)

    @Query("Select * from ItemsEntity")
    fun getItemsEntity(): List<ItemsEntity>

    @Query("Select(Select COUNT(*) from ItemsEntity) != 0")
    fun doesItemsEntityExists(): Boolean

    @Query("Delete from ItemsEntity where description = :description")
    fun deleteItemByDescription(description: String)
}