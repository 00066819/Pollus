package com.groupproject.pollusapp.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.dgasteazoro.dummydictionary.ui.ViewModelFactory
import com.dgasteazoro.dummydictionary.ui.login.LoginUiStatus
import com.dgasteazoro.dummydictionary.ui.login.LoginViewModel
import com.groupproject.pollusapp.MainActivity
import com.groupproject.pollusapp.PollusApplication
import com.groupproject.pollusapp.R
import com.groupproject.pollusapp.databinding.FragmentLoginBinding


class Login : AppCompatActivity() {

    private lateinit var binding: FragmentLoginBinding
    val app by lazy {
        application as PollusApplication
    }
    private val viewModelFactory by lazy {
        ViewModelFactory(app.getLoginRepository())
    }
    private val viewModel: LoginViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (app.isUserLogin()) {
            return startMainActivity()
        }
        binding = DataBindingUtil.setContentView(this, R.layout.fragment_login)
        binding.viewModel= viewModel

        viewModel.status.observe(this) { status ->
            handleUiState(status)
        }
    }

    private fun handleUiState(status: LoginUiStatus) {
        when (status) {
            is LoginUiStatus.Error -> Log.d("Login List Status", "Error")
            LoginUiStatus.Loading -> Log.d("Login List Status", "Loading")
            LoginUiStatus.Resume -> Log.d("Login List Status", "Resume")
            is LoginUiStatus.Success -> {
                app.saveAuthToken(status.token)
                startMainActivity()
            }
        }
    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
    }
