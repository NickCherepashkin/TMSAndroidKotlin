package com.drozdova.tms.tmsandroidkotlin.data

import com.drozdova.tms.tmsandroidkotlin.data.model.ItemsResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/nkuYRM")
    fun getData() : Single<ItemsResponse>
}