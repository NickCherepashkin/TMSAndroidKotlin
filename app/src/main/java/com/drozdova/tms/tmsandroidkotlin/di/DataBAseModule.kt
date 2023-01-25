package com.drozdova.tms.tmsandroidkotlin.di

import android.content.Context
import com.drozdova.tms.tmsandroidkotlin.data.database.dao.ItemsDAO
import com.drozdova.tms.tmsandroidkotlin.data.database.dao.ItemsDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataBAseModule {
    @Provides
    fun providesItemsDAO(itemsDataBase: ItemsDataBase): ItemsDAO {
        return itemsDataBase.getItemsDAO()
    }

    @Provides
    fun itemsDatabesr(context: Context): ItemsDataBase {
        return ItemsDataBase.getItemsDataBaseInstance(context)

    }
}