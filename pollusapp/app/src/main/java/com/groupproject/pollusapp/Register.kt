package com.groupproject.pollusapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import com.groupproject.pollusapp.network.dto.LoginRequest
import com.groupproject.pollusapp.network.dto.RegisterRequest
import com.groupproject.pollusapp.ui.login.LoginViewModel
import com.groupproject.pollusapp.ui.login.RegisterViewModel

class Register : AppCompatActivity() {

    private lateinit var arrow_return: ImageButton
    private lateinit var btn_register: Button
    private lateinit var username_ti: TextInputEditText
    private lateinit var email_ti: TextInputEditText
    private lateinit var name_ti: TextInputEditText
    private lateinit var lastname_ti: TextInputEditText
    private lateinit var password_ti: TextInputEditText
    private lateinit var org_ti: TextInputEditText
    private val registerViewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        getSupportActionBar()?.hide()

        bin()
        addListener()
        registerViewModel.registerStatus.observe(this) {
            if (it) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                MaterialAlertDialogBuilder(
                    this,
                    com.google.android.material.R.style.ThemeOverlay_MaterialComponents_Dialog
                )
                    .setMessage(resources.getString(R.string.register_error))
                    .setPositiveButton(resources.getString(R.string.boton_aceptar)) { dialog, which ->
                        // Respond to positive button press
                    }
                    .show()
            }
        }
    }

    private fun bin(){
        arrow_return = findViewById(R.id.arrowReturn)
        btn_register = findViewById(R.id.login_button)
        username_ti = findViewById(R.id.username_register_ti)
        email_ti = findViewById(R.id.email_register_ti)
        name_ti = findViewById(R.id.name_register_ti)
        lastname_ti = findViewById(R.id.lastname_register_ti)
        password_ti = findViewById(R.id.password_register_ti)
        org_ti = findViewById(R.id.code_register_ti)
    }

    private fun addListener(){
        arrow_return.setOnClickListener(){
            this.finish()
        }

        btn_register.setOnClickListener() {
            registerViewModel.register(RegisterRequest(username_ti.text.toString(), email_ti.text.toString(),
            name_ti.text.toString(), lastname_ti.text.toString(), password_ti.text.toString(), org_ti.text.toString()))
        }

    }
}