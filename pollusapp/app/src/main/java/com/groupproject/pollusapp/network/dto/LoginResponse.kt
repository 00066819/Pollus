package com.groupproject.pollusapp.network.dto

import com.google.gson.annotations.SerializedName

data class LoginResponse (@SerializedName("token") val token: String)