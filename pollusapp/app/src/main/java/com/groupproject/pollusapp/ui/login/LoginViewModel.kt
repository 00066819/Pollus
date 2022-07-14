package com.groupproject.pollusapp.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.groupproject.pollusapp.network.RetrofitInstance
import com.groupproject.pollusapp.network.dto.LoginRequest
import com.groupproject.pollusapp.repository.LoginRepository
import kotlinx.coroutines.launch



class LoginViewModel: ViewModel(){

    var loginStatus = MutableLiveData<Boolean>()

private val repository = LoginRepository()

fun logIn(user: LoginRequest){
    viewModelScope.launch {
        val result = repository.login(user)
            if (!result.token.isNullOrEmpty()){
                RetrofitInstance.setToken(result.token)
                loginStatus.postValue(true)
                Log.i("DEBUG", result.token)
            }
        else loginStatus.postValue(false)
    }


    }
}