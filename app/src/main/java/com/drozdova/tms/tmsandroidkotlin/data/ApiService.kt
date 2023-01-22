package com.drozdova.tms.tmsandroidkotlin.data

import com.drozdova.tms.tmsandroidkotlin.data.model.UserInfo
import com.drozdova.tms.tmsandroidkotlin.data.model.UsersResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/users")
    suspend fun getData() : Response<List<UserInfo>>
}