package com.drozdova.tms.tmsandroidkotlin.di

import com.drozdova.tms.tmsandroidkotlin.data.repository.ItemsRepositoryImpl
import com.drozdova.tms.tmsandroidkotlin.domain.repository.ItemsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindItemsRepository(itemRepository: ItemsRepositoryImpl): ItemsRepository
}