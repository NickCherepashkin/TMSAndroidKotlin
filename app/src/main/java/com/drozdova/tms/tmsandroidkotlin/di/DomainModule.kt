package com.drozdova.tms.tmsandroidkotlin.di

import com.drozdova.tms.tmsandroidkotlin.domain.AuthInteractor
import com.drozdova.tms.tmsandroidkotlin.domain.ItemsInteractor
import com.drozdova.tms.tmsandroidkotlin.domain.repository.AuthRepository
import com.drozdova.tms.tmsandroidkotlin.domain.repository.ItemsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DomainModule {

    @Provides
    fun provideItemsInteractor( itemRepository: ItemsRepository) : ItemsInteractor{
        return ItemsInteractor(itemRepository)
    }

    @Provides
    fun provideAuthInteractor( authRepository: AuthRepository) : AuthInteractor {
        return AuthInteractor(authRepository)
    }
}