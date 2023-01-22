package com.drozdova.tms.tmsandroidkotlin.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.drozdova.tms.tmsandroidkotlin.data.ApiService
import com.drozdova.tms.tmsandroidkotlin.data.auth.HomeRepositoryImpl
import com.drozdova.tms.tmsandroidkotlin.data.auth.LoginRepositoryImpl
import com.drozdova.tms.tmsandroidkotlin.data.items.ItemsRepositoryImpl
import com.drozdova.tms.tmsandroidkotlin.data.items.OnBoardingRepositoryImpl
import com.drozdova.tms.tmsandroidkotlin.data.sharedprefs.SharedPreferencesHelper
import com.drozdova.tms.tmsandroidkotlin.domain.auth.HomeRepository
import com.drozdova.tms.tmsandroidkotlin.domain.auth.LoginRepository
import com.drozdova.tms.tmsandroidkotlin.domain.auth.OnBoardingRepository
import com.drozdova.tms.tmsandroidkotlin.domain.items.ItemsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun binItemsRepository(itemsRepositoryImpl: ItemsRepositoryImpl) : ItemsRepository

    @Binds
    abstract fun binLoginRepository(loginRepositoryImpl:LoginRepositoryImpl) : LoginRepository

    @Binds
    abstract fun binOnBoardingRepository(honBoardingRepositoryImpl: OnBoardingRepositoryImpl) : OnBoardingRepository

    @Binds
    abstract fun binHomeRepository(homeRepositoryImpl: HomeRepositoryImpl) : HomeRepository

    companion object {
        private const val SP_KEY = "SP_KEY"
        private const val DATA_URL = "https://jsonplaceholder.typicode.com"

        @Provides
        fun provideSharedPreferences(@ApplicationContext context: Context) : SharedPreferencesHelper{
            return SharedPreferencesHelper(context.getSharedPreferences(SP_KEY, MODE_PRIVATE))
        }

        @Provides
        fun provideretrofitImpl(retrofit: Retrofit) : ApiService {
            return retrofit.create(ApiService::class.java)
        }

        @Provides
        fun provideRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(DATA_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}