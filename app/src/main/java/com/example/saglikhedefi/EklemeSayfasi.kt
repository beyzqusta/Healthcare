package com.example.saglikhedefi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.saglikhedefi.databinding.ActivityEklemeSayfasiBinding

class EklemeSayfasi : AppCompatActivity() {
    private lateinit var binding:ActivityEklemeSayfasiBinding
    private lateinit var db:NoteDatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityEklemeSayfasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NoteDatabaseHelper(this)
        binding.saveButton.setOnClickListener{
            val title =binding.titleEditText.text.toString()
            val content=binding.contenEditText.text.toString()
            val note=Note(0,title,content)
            db.insertNote(note)
            finish()
            Toast.makeText(this,"note saved",Toast.LENGTH_SHORT).show()
        }
    }
}