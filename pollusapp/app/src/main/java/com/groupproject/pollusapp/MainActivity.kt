package com.groupproject.pollusapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var btn_login: Button
    private lateinit var text_register: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)

        getSupportActionBar()?.hide()

        bin()
        addListener()
    }

    private fun bin(){
        btn_login = findViewById(R.id.login_button)
        text_register = findViewById(R.id.no_acount_register_textview)
    }

    private fun addListener(){
        text_register.setOnClickListener(){
            val intent = Intent(this,Register::class.java)
            startActivity(intent)
        }

        btn_login.setOnClickListener(){
            val intent = Intent(this,MainMenu::class.java)
            startActivity(intent)
        }

    }
}