package com.example.healtcare1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        val getData = intent.getParcelableExtra<DtaClass>("android")
        if (getData != null) {
            val detailTitle: TextView = findViewById(R.id.detailTitle)
            val detailDesc: TextView = findViewById(R.id.detailDesc)
            val detailImage: ImageView = findViewById(R.id.detailImage)

            detailTitle.text = getData.dataTitle
            detailDesc.text = getData.dataDesc
            detailImage.setImageResource(getData.dataDetailImage)
        }

        val yor=findViewById<Button>(R.id.yorumyap)
        yor.setOnClickListener {
            val yap=Intent(this,MainActivity::class.java)
            startActivity(yap)
        }

    }
}