package com.drozdova.tms.tmsandroidkotlin.di

import android.content.Context
import android.content.SharedPreferences
import com.drozdova.tms.tmsandroidkotlin.data.ApiService
import com.drozdova.tms.tmsandroidkotlin.data.ApiServiceSecond
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
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

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
        private const val BASE_URL_SECOND = " https://jsonplaceholder.typicode.com"
        @Provides
        fun provideSharedPref (@ApplicationContext context: Context) : SharedPreferencesHelper {
            return SharedPreferencesHelper(
                context.getSharedPreferences(SP_KEY, Context.MODE_PRIVATE)
            )
        }

        @Provides
        @Named("FIRST")
        fun provideApiService(@Named("FIRST")retrofit: Retrofit) : ApiService{
            return retrofit.create(ApiService::class.java)
        }

        @Provides
        @Named("FIRST")
        fun provideRetrofitInstance() : Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }

        @Provides
        @Named("SECOND")
        fun provideApiServiceSecond(@Named("SECOND")retrofit: Retrofit) : ApiServiceSecond{
            return retrofit.create(ApiServiceSecond::class.java)
        }

        @Provides
        @Named("SECOND")
        fun provideRetrofitInstanceSecond() : Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL_SECOND)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }


    }
}