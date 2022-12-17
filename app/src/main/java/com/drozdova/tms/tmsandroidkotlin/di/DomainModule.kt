package com.drozdova.tms.tmsandroidkotlin.di

import com.drozdova.tms.tmsandroidkotlin.domain.ItemsInteractor
import com.drozdova.tms.tmsandroidkotlin.domain.repository.ItemsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun provideItemRepository( itemRepository: ItemsRepository) : ItemsInteractor{
        return ItemsInteractor(itemRepository)
    }
}