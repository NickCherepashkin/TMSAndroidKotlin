package com.drozdova.tms.tmsandroidkotlin

import android.app.Application
import com.drozdova.tms.tmsandroidkotlin.di.AppModule
import com.drozdova.tms.tmsandroidkotlin.di.component.AppComponent
import com.drozdova.tms.tmsandroidkotlin.di.component.DaggerAppComponent
import dagger.Component

class App : Application() {

    lateinit var appComponent: AppComponent

    fun provideAppComponent() : AppComponent {
        this.appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()

        return appComponent
    }

}