package com.drozdova.tms.tmsandroidkotlin.data.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.drozdova.tms.tmsandroidkotlin.data.database.FavouriteEntity
import com.drozdova.tms.tmsandroidkotlin.data.database.UsersEntity

@Database(entities = [UsersEntity::class, FavouriteEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getUsersDAO(): UsersDAO

    companion object {
        private const val DATABASE_NAME = "app_db"
        private var DATABASE_INSTANCE: AppDatabase? = null
        fun getAppDatabeseInstance(context: Context): AppDatabase {
            return DATABASE_INSTANCE ?: Room
                .databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME
                )
                .build()
                .also { DATABASE_INSTANCE = it }
        }
    }
}