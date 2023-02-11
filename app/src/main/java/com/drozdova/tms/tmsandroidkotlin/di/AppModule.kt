package com.drozdova.tms.tmsandroidkotlin.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(
    private  val application: Application
) {
    @Provides
    fun provideContext() : Context {
        return this.application
    }

    @Provides
    fun provideApplicaion(): Application = this.application

}