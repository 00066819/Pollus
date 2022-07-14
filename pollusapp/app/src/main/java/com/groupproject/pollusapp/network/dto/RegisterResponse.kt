package com.groupproject.pollusapp.network.dto

import com.google.gson.annotations.SerializedName

data class RegisterResponse (
    @SerializedName("_id") val id: String?,
    @SerializedName("role") val role: String?
)