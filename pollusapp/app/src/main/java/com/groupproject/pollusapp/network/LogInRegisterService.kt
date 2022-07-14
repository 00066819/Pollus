package com.groupproject.pollusapp.network

import com.groupproject.pollusapp.network.dto.LoginRequest
import com.groupproject.pollusapp.network.dto.LoginResponse
import com.groupproject.pollusapp.network.dto.RegisterRequest
import com.groupproject.pollusapp.network.dto.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LogInRegisterService {

    suspend fun login(credential: LoginRequest): LoginResponse{
        return withContext(Dispatchers.IO){
            RetrofitInstance
                .Service()
                .login(credential)
                .body()?: LoginResponse(
                ""
            )
        }
    }
    suspend fun register(credential: RegisterRequest): RegisterResponse{
        return withContext(Dispatchers.IO){
            RetrofitInstance
                .Service()
                .register(credential)
                .body()?:RegisterResponse(
                "",""
                )
        }
    }
}

