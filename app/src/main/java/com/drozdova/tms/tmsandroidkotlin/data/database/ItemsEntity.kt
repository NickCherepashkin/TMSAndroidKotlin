package com.drozdova.tms.tmsandroidkotlin.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "ItemsEntity")
data class ItemsEntity(
//    @ColumnInfo(name = "id")
//    val id: Int,
    @PrimaryKey
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "imageUrl")
    val imageUrl: String
)
