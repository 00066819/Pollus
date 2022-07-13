package com.groupproject.pollusapp

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.groupproject.pollusapp.network.RetrofitInstance
import com.groupproject.pollusapp.repository.LoginRepository

class PollusApplication: Application() {
    private val prefs: SharedPreferences by lazy {
        getSharedPreferences("DummyDictionary", Context.MODE_PRIVATE)
    }


    private fun getAPIService() = with(RetrofitInstance) {
        setToken(getToken())
        getWordServices()

    }


fun getLoginRepository() =
        LoginRepository(getAPIService())

    private fun getToken(): String = prefs.getString(USER_TOKEN, "")!!

    fun isUserLogin() = getToken() != ""

    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    companion object {
        const val USER_TOKEN = "user_token"
    }
}