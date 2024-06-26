package com.example.healtcare1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.healtcare1.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var db:NoteDataBaseHelper
    private lateinit var notesAdapter: NoteAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db= NoteDataBaseHelper(this)
        notesAdapter= NoteAdapter(db.getAllNotes(),this)


        binding.notesRecyclerView.layoutManager= LinearLayoutManager(this)
        binding.notesRecyclerView.adapter=notesAdapter

        binding.Floatingbutton.setOnClickListener{
            val intent =Intent (this,EklemeSayfasi::class.java)
            startActivity(intent)
        }


    }
    override fun onResume(){
        super.onResume()
        notesAdapter.refreshData(db.getAllNotes())




        }

    }
