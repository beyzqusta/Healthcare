package com.example.healtcare1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.healtcare1.databinding.ActivityEklemeSayfasiBinding

class EklemeSayfasi : AppCompatActivity() {

    private lateinit var binding: ActivityEklemeSayfasiBinding
    private lateinit var db:NoteDataBaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)

        binding=ActivityEklemeSayfasiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = NoteDataBaseHelper(this)
        binding.saveButton.setOnClickListener{
            val title =binding.titleEditText.text.toString()
            val content=binding.contenEditText.text.toString()
            val note=Note(0,title,content)
            db.insertNote(note)
            finish()
            Toast.makeText(this,"Yorum Eklendi",Toast.LENGTH_SHORT).show()


        }
    }
}