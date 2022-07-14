package com.groupproject.pollusapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import com.groupproject.pollusapp.network.dto.LoginRequest
import com.groupproject.pollusapp.ui.login.LoginViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var btn_login: Button
    private lateinit var text_register: TextView
    private lateinit var login_username: TextInputEditText
    private lateinit var login_password: TextInputEditText
    private val logInViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)

        getSupportActionBar()?.hide()

        bin()
        addListener()
        logInViewModel.loginStatus.observe(this){
            if (it) {
                val intent = Intent(this, MainMenu::class.java)
                startActivity(intent)
            }
            else {
                MaterialAlertDialogBuilder(
                    this,
                    com.google.android.material.R.style.ThemeOverlay_MaterialComponents_Dialog
                )
                    .setMessage(resources.getString(R.string.error_message))
                    .setPositiveButton(resources.getString(R.string.boton_aceptar)) { dialog, which ->
                        // Respond to positive button press
                    }
                    .show()
            }
        }
    }

    private fun bin(){
        btn_login = findViewById(R.id.login_button)
        text_register = findViewById(R.id.no_acount_register_textview)
        login_username = findViewById(R.id.login_username)
        login_password = findViewById(R.id.login_password)
    }

    private fun addListener(){
        text_register.setOnClickListener(){
            val intent = Intent(this,Register::class.java)
            startActivity(intent)
        }

        btn_login.setOnClickListener(){
            logInViewModel.logIn(LoginRequest(login_username.text.toString(), login_password.text.toString()))
        }

    }
}