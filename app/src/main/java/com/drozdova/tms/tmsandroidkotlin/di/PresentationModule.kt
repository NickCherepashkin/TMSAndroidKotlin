package com.drozdova.tms.tmsandroidkotlin.di

import com.drozdova.tms.tmsandroidkotlin.domain.ListInteractor
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.ListPresenter
import com.drozdova.tms.tmsandroidkotlin.presentation.presenter.ListView
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PresentationModule {

    @Provides
    fun provideListPresenter(listView: ListView, listInteractor: ListInteractor) : ListPresenter{
        return ListPresenter(listView, listInteractor)
    }

//    companion object {
//
//    }
}