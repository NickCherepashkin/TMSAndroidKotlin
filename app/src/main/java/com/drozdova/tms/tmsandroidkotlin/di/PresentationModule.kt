package com.drozdova.tms.tmsandroidkotlin.di

import com.drozdova.tms.tmsandroidkotlin.domain.AuthInteractor
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.HomePresenter
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.LoginPresenter
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.MainPresenter
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.OnBoardingPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PresentationModule {

    @Provides
    fun provideMainPresenter(authInteractor: AuthInteractor) : MainPresenter {
        return MainPresenter(authInteractor)
    }

    @Provides
    fun provideLoginPresenter(authInteractor: AuthInteractor) : LoginPresenter {
        return LoginPresenter(authInteractor)
    }

    @Provides
    fun provideOnBoardingPresenter() : OnBoardingPresenter {
        return OnBoardingPresenter()
    }

    @Provides
    fun provideHomePresenter(authInteractor: AuthInteractor) : HomePresenter {
        return HomePresenter(authInteractor)
    }
}