package com.groupproject.pollusapp.repository

import com.groupproject.pollusapp.network.ApiResponse
import com.groupproject.pollusapp.network.LogInRegisterService
import com.groupproject.pollusapp.network.dto.LoginRequest
import com.groupproject.pollusapp.network.dto.LoginResponse
import com.groupproject.pollusapp.network.dto.RegisterRequest
import com.groupproject.pollusapp.network.dto.RegisterResponse
import retrofit2.HttpException
import java.io.IOException

class LoginRepository {
    private val api = LogInRegisterService()

    suspend fun login(credential: LoginRequest): LoginResponse {
        return api.login(credential)
    }

    suspend fun register(credential: RegisterRequest): RegisterResponse {
        return api.register(credential)
    }
}