package com.example.ilacc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ilacc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), IlacItemClickListener
{
    private lateinit var binding: ActivityMainBinding
    private lateinit var ilacViewModel: IlacViewModel

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ilacViewModel = ViewModelProvider(this).get(IlacViewModel::class.java)
        binding.newTaskButton.setOnClickListener {
            NewIlacSheet(null).show(supportFragmentManager, "newTaskTag")
        }
        setRecyclerView()
    }

    private fun setRecyclerView()
    {
        val mainActivity = this
        ilacViewModel.ilacItems.observe(this){
            binding.todoListRecyclerView.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = IlacItemAdapter(it, mainActivity)
            }
        }
    }

    override fun ilacDuzenleItem(ilacItem: IlacItem)
    {
        NewIlacSheet(ilacItem).show(supportFragmentManager,"newTaskTag")
    }

    override fun ilacTamamlaItem(ilacItem: IlacItem)
    {
        ilacViewModel.setCompleted(ilacItem)
    }
}






