package com.example.healtcare1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.healtcare1.databinding.ActivityLoginBinding
import com.example.healtcare1.databinding.ActivitySignupBinding

class signup : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var dataBaseHelper: DataBaseHelper



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataBaseHelper=DataBaseHelper(this)

        binding.signButton.setOnClickListener {

            val SignupUsername = binding.signUsername.text.toString()
            val SingUppassword = binding.signPasswordd.text.toString()
            signupDatabase(SignupUsername,SingUppassword)

        }




    }

    private fun signupDatabase(username: String, password: String){
        val insertRowId = dataBaseHelper.insertUser(username, password)
        if(insertRowId != -1L){
            Toast.makeText(this , "Sign Up basarili ", Toast.LENGTH_SHORT).show()
            val intent = Intent(this ,Login::class.java)
            startActivity(intent)
            finish()
        }
        else {

            Toast.makeText(this,"Sign Up basarisiz ",Toast.LENGTH_SHORT).show()
        }


    }


}