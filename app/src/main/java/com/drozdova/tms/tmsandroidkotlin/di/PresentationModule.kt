package com.drozdova.tms.tmsandroidkotlin.di

import com.drozdova.tms.tmsandroidkotlin.domain.auth.LoginInteractor
import com.drozdova.tms.tmsandroidkotlin.domain.items.ItemsListInteractor
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PresentationModule {

    @Provides
    fun provideListPresenter(listInteractor: ItemsListInteractor) : ListPresenter {
        return ListPresenter(listInteractor)
    }

    @Provides
    fun provideLoginPresenter(loginInteractor: LoginInteractor) : LoginPresenter {
        return LoginPresenter(loginInteractor)
    }

    @Provides
    fun provideHomePresenter(loginInteractor: LoginInteractor) : HomePresenter {
        return HomePresenter(loginInteractor)
    }

    @Provides
    fun provideMainPresenter(loginInteractor: LoginInteractor) : MainPresenter {
        return MainPresenter(loginInteractor)
    }

    @Provides
    fun provideDetailsPresenter(loginInteractor: LoginInteractor) : DetailsPresenter {
        return DetailsPresenter(loginInteractor)
    }

    @Provides
    fun provideOnBoardingPresenter() : OnBoardingPresenter {
        return OnBoardingPresenter()
    }
}