package com.dgasteazoro.dummydictionary.network

import com.groupproject.pollusapp.network.dto.LoginRequest
import com.groupproject.pollusapp.network.dto.LoginResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Service {


        @POST("/login")
        suspend fun login(@Body credentials: LoginRequest): LoginResponse


}