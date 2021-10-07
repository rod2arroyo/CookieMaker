package com.example.cookiemaker

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editName = findViewById<EditText>(R.id.editName)
        val btnIngresar = findViewById<Button>(R.id.btnIngresar)

        btnIngresar.setOnClickListener{_ : View ->
            if(editName.text.toString() != ""){
                val intent : Intent = Intent()
                intent.setClass(this,MainActivity::class.java)
                val bundle : Bundle = Bundle()
                bundle.putString("username",editName.text.toString())
                intent.putExtra("data",bundle)
                startActivity(intent)
            }else{
                Toast.makeText(this,"No se lleno el campo de nombre",Toast.LENGTH_SHORT).show()
            }

        }
    }
}