package com.groupproject.pollusapp.network.dto

import com.google.gson.annotations.SerializedName

data class RegisterRequest (
    @SerializedName("username") val username: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("lastName") val lastName: String?,
    @SerializedName("password") val password: String?,
    @SerializedName("org") val org: String?,
    @SerializedName("role") val role: String? = "user"
    )