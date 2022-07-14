package com.groupproject.pollusapp.network.dto

import android.text.Editable
import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("username") val username: String?,
    @SerializedName("password") val password: String?
)