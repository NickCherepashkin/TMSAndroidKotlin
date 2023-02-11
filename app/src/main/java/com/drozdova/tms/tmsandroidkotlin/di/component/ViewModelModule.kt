package com.drozdova.tms.tmsandroidkotlin.di.component

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.drozdova.tms.tmsandroidkotlin.di.factory.ViewModelFactory
import com.drozdova.tms.tmsandroidkotlin.di.factory.ViewModelKey
import com.drozdova.tms.tmsandroidkotlin.presentation.viewmodel.*
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factoryApp:ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(OnBoardingViewModel::class)
    abstract fun bindOnBoardingViewModel(viewModel: OnBoardingViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ItemsViewModel::class)
    abstract fun bindItemsViewModel(viewModel: ItemsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    abstract fun bindDetailsViewModel(viewModel: DetailsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavouriteItemsViewModel::class)
    abstract fun bindFavoriteViewModel(viewModel: FavouriteItemsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindSearchViewModel(viewModel: SearchViewModel): ViewModel
}