package com.groupproject.pollusapp.repository

import com.groupproject.pollusapp.network.ApiResponse
import com.groupproject.pollusapp.network.WordService
import com.groupproject.pollusapp.network.dto.LoginRequest
import retrofit2.HttpException
import java.io.IOException

class LoginRepository(private val api: WordService) {

    suspend fun login(username: String, password: String): ApiResponse<String> {
        try {

            val response = api.login(LoginRequest(username, password))
            return ApiResponse.Success(response.token)

        } catch (e: HttpException) {
            if (e.code() == 400) {
                //TODO: convert body to Kotlin object
                return ApiResponse.ErrorWithMessage(e.response()?.body().toString())
            }
            return ApiResponse.Error(e)
        } catch (e: IOException) {
            return ApiResponse.Error(e)
        }
    }
}