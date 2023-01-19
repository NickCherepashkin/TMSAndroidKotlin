package com.drozdova.tms.tmsandroidkotlin.di

import com.drozdova.tms.tmsandroidkotlin.domain.auth.*
import com.drozdova.tms.tmsandroidkotlin.domain.items.ItemsListInteractor
import com.drozdova.tms.tmsandroidkotlin.domain.items.ItemsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideItemsInteractor(itemsRepository: ItemsRepository) : ItemsListInteractor {
        return ItemsListInteractor(itemsRepository)
    }

    @Provides
    fun provideLoginInteractor(loginRepository: LoginRepository) : LoginInteractor {
        return LoginInteractor(loginRepository)
    }

    @Provides
    fun provideOnBoardingInteractor(onBoardingRepository: OnBoardingRepository) : OnBoardingInteractor {
        return OnBoardingInteractor(onBoardingRepository)
    }

    @Provides
    fun provideHomeInteractor(homeRepository: HomeRepository) : HomeInteractor {
        return HomeInteractor(homeRepository)
    }
}