package com.drozdova.tms.tmsandroidkotlin.di

import android.app.Application
import com.drozdova.tms.tmsandroidkotlin.di.component.AppComponent
import dagger.Component

class App : Application() {

    lateinit var appComponent: AppComponent

    fun providesAppCmponent() : AppComponent {
//        appComponent = DaggerAppComponent
//            .builder()
//            .appModule(AppModule(this))
//            .build()

        return appComponent
    }

}