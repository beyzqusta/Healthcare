package com.example.healtcare1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.ai.client.generativeai.GenerativeModel

import kotlinx.coroutines.runBlocking

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val eTPrompt= findViewById<EditText>(R.id.eTPrompt)
        val btnSubmit= findViewById<Button>(R.id.btnSubmit)
        val tVResult= findViewById<TextView>(R.id.tVResult)

        btnSubmit.setOnClickListener {
            val prompt= eTPrompt.text.toString()

            val generativeModel = GenerativeModel(
                // For text-only input, use the gemini-pro model
                modelName = "gemini-pro",
                apiKey = "AIzaSyBtohQVZBrGXaWePkvSfueTjLyrFybovlE"
                // ENTER YOUR KEY
            )
            runBlocking {
                val response = generativeModel.generateContent(prompt)
                tVResult.text= response.text
            }
        }

    }
}