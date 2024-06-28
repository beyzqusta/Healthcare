package com.example.saglikhedefi

import android.content.Intent
import android.os.Binder
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.saglikhedefi.databinding.ActivityLoginBinding
import com.example.saglikhedefi.DashBoards
import com.example.saglikhedefi.DataBaseHelper

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var dataBaseHelper: DataBaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataBaseHelper = DataBaseHelper(this)

        binding.loginButton.setOnClickListener{
            val username=binding.loginUsername.text.toString()
            val passwordd=binding.loginPasswordd.text.toString()
            loginDatabase(username,passwordd)

        }


    }

    private fun loginDatabase(username:String,password:String){
        val userExists = dataBaseHelper.readUser(username, password)
        if(userExists) {
            Toast.makeText(this, "Giris basarili", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, DashBoards::class.java)
            startActivity(intent)
            finish()
        }

        else{
            Toast.makeText(this,"Giris yapilamadi" ,Toast.LENGTH_SHORT).show()

        }


    }




}