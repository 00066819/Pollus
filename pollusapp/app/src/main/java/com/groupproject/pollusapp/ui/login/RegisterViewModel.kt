package com.groupproject.pollusapp.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.groupproject.pollusapp.network.RetrofitInstance
import com.groupproject.pollusapp.network.dto.LoginRequest
import com.groupproject.pollusapp.network.dto.RegisterRequest
import com.groupproject.pollusapp.repository.LoginRepository
import kotlinx.coroutines.launch

class RegisterViewModel: ViewModel() {

    var registerStatus = MutableLiveData<Boolean>()

    private val repository = LoginRepository()

    fun register(user: RegisterRequest){
        viewModelScope.launch {
            val result = repository.register(user)
            if (!result.id.isNullOrEmpty()) {
                registerStatus.postValue(true)
                Log.i("DEBUG", result.id+", "+result.role)
            }
            else registerStatus.postValue(false)
        }



    }

}