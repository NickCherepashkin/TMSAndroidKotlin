package com.drozdova.tms.tmsandroidkotlin.data

import com.drozdova.tms.tmsandroidkotlin.data.model.ItemsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/nkuYRM")
    suspend fun getData() : Response<ItemsResponse>
}