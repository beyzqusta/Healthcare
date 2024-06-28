package com.example.saglikhedefi

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



        val saglik =findViewById<Button>(R.id.saglikon)
        saglik.setOnClickListener {
            val intent = Intent(this,EklemeSayfasi::class.java)
            startActivity(intent)

        }

        val cikissyap=findViewById<Button>(R.id.ccii)
        cikissyap.setOnClickListener {
            val ciik=Intent(this,NoteDatabaseHelper::class.java)
            startActivity(ciik)
            finish()
        }


        val kob =findViewById<Button>(R.id.kan)
        kob.setOnClickListener {
            val k= Intent(this,KanOrganBagis::class.java)
            startActivity(k)
        }











    }
}