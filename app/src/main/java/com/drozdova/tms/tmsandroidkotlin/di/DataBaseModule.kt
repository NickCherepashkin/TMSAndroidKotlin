package com.drozdova.tms.tmsandroidkotlin.di

import android.content.Context
import com.drozdova.tms.tmsandroidkotlin.data.database.dao.AppDatabase
import com.drozdova.tms.tmsandroidkotlin.data.database.dao.LoginDAO
import com.drozdova.tms.tmsandroidkotlin.data.database.dao.UsersDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Provides
    fun providesUsersDAO(itemsDataBase: AppDatabase): UsersDAO {
        return itemsDataBase.getUsersDAO()
    }

    @Provides
    fun providesLoginDAO(itemsDataBase: AppDatabase): LoginDAO {
        return itemsDataBase.getLoginDAO()
    }

    @Provides
    fun itemsDatabase(context: Context): AppDatabase {
        return AppDatabase.getAppDatabeseInstance(context)

    }
}