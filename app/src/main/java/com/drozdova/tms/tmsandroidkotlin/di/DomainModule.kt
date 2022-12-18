package com.drozdova.tms.tmsandroidkotlin.di

import com.drozdova.tms.tmsandroidkotlin.domain.ListInteractor
import com.drozdova.tms.tmsandroidkotlin.domain.repository.ItemsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideItemsInteractor(itemsRepository: ItemsRepository) : ListInteractor{
        return ListInteractor(itemsRepository)
    }
}