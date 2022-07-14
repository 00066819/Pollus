package com.groupproject.pollusapp.network.dto

import com.groupproject.pollusapp.network.dto.LoginRequest
import com.groupproject.pollusapp.network.dto.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Service {

        @POST("api/register")
        suspend fun register(@Body credentials: RegisterRequest): Response<RegisterResponse>

        @POST("/api/login")
        suspend fun login(@Body credentials: LoginRequest): Response<LoginResponse>



}