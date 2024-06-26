package com.example.healtcare1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent as Intent1

class DashBoards : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dash_boards)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val i =findViewById<Button>(R.id.doktorr)
        i.setOnClickListener {
            val intent = Intent(this,MainActivity3::class.java)
            startActivity(intent)

        }

        val cikissyap=findViewById<Button>(R.id.ccii)
        cikissyap.setOnClickListener {
            val ciik=Intent(this,NoteDataBaseHelper::class.java)
            startActivity(ciik)
            finish()
        }


        val api =findViewById<Button>(R.id.api)
        api.setOnClickListener {
            val a= Intent(this,MainActivity2::class.java)
            startActivity(a)
        }











    }
}