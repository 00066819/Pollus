package com.groupproject.pollusapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class Register : AppCompatActivity() {

    private lateinit var arrow_return: ImageButton
    private lateinit var btn_register: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        getSupportActionBar()?.hide()

        bin()
        addListener()
    }

    private fun bin(){
        arrow_return = findViewById(R.id.arrowReturn)
        btn_register = findViewById(R.id.login_button)
    }

    private fun addListener(){
        arrow_return.setOnClickListener(){
            this.finish()
        }

        btn_register.setOnClickListener() {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Registro Completado")
            builder.setMessage("lorem lorem lorem")

            //mostrar el boton continuar en la burbuja de texto emergente
            builder.setNeutralButton("Continuar") { dialog, which ->
                Toast.makeText(
                    applicationContext,
                    "Continuar", Toast.LENGTH_SHORT
                ).show()


                this.finish()
            }
            builder.show()
        }

    }
}