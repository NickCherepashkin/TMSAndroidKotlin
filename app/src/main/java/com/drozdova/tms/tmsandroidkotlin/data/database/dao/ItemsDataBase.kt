package com.drozdova.tms.tmsandroidkotlin.data.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.drozdova.tms.tmsandroidkotlin.data.database.ItemsEntity

@Database(entities = [ItemsEntity::class], version = 1, exportSchema = false)
abstract class ItemsDataBase: RoomDatabase() {

    abstract fun getItemsDAO(): ItemsDAO

    companion object {
        private var DB_INSTANCE: ItemsDataBase? = null

        fun getItemsDataBaseInstance(context: Context) : ItemsDataBase {
            return DB_INSTANCE ?: Room
                .databaseBuilder(
                    context.applicationContext,
                    ItemsDataBase::class.java,
                    "ITEMS_DB"
                )
                .build()
                .also { DB_INSTANCE = it }
        }
    }
}