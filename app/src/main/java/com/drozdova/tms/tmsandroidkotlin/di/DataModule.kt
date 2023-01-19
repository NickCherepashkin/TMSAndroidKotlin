package com.drozdova.tms.tmsandroidkotlin.di

import android.content.Context
import android.content.SharedPreferences
import com.drozdova.tms.tmsandroidkotlin.data.ApiService
import com.drozdova.tms.tmsandroidkotlin.data.auth.AuthRepositoryImpl
import com.drozdova.tms.tmsandroidkotlin.data.items.ItemsRepositoryImpl
import com.drozdova.tms.tmsandroidkotlin.data.sharedpref.SharedPreferencesHelper
import com.drozdova.tms.tmsandroidkotlin.domain.repository.AuthRepository
import com.drozdova.tms.tmsandroidkotlin.domain.repository.ItemsRepository
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
    abstract fun bindItemsRepository(itemRepository: ItemsRepositoryImpl): ItemsRepository

    @Binds
    abstract fun bindAuthRepository(authRepository: AuthRepositoryImpl): AuthRepository

    companion object {
        private const val SP_KEY = "SP_KEY"
        private const val BASE_URL = "https://api.jsonserve.com"
        @Provides
        fun provideSharedPref (@ApplicationContext context: Context) : SharedPreferencesHelper {
            return SharedPreferencesHelper(
                context.getSharedPreferences(SP_KEY, Context.MODE_PRIVATE)
            )
        }

        @Provides
        fun provideApiService(retrofit: Retrofit) : ApiService{
            return retrofit.create(ApiService::class.java)
        }

        @Provides
        fun provideRetrofitInstance() : Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}