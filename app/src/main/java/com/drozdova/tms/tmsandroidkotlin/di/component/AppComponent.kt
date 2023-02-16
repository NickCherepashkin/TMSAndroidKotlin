package com.drozdova.tms.tmsandroidkotlin.di.component

import com.drozdova.tms.tmsandroidkotlin.di.*
import com.drozdova.tms.tmsandroidkotlin.di.factory.ScreenScope
import com.drozdova.tms.tmsandroidkotlin.presentation.MainActivity
import com.drozdova.tms.tmsandroidkotlin.presentation.view.auth.LoginFragment
import com.drozdova.tms.tmsandroidkotlin.presentation.view.home.DetailsFragment
import com.drozdova.tms.tmsandroidkotlin.presentation.view.home.HomeFragment
import com.drozdova.tms.tmsandroidkotlin.presentation.view.home.items.FavouriteFragment
import com.drozdova.tms.tmsandroidkotlin.presentation.view.home.items.ItemsFragment
import com.drozdova.tms.tmsandroidkotlin.presentation.view.home.items.SearchFragment
import dagger.Component

@Component (
    modules = [
        AppModule::class,
        DataBAseModule::class,
        DataModule::class,
        DomainModule::class,
        ViewModelModule::class
    ]
)

@ScreenScope
interface AppComponent {
    fun inject(loginFragment: LoginFragment)
    fun inject(detailsFragment: DetailsFragment)
    fun inject(itemsFragment: ItemsFragment)
    fun inject(favouriteFragment: FavouriteFragment)
    fun inject(searchFragment: SearchFragment)
    fun inject(homeFragment: HomeFragment)
    fun inject(mainActivity: MainActivity)
}