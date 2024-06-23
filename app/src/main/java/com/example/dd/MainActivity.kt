package com.example.dd

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    lateinit var imageList:Array<Int>
    lateinit var titleList:Array<String>
    lateinit var descList: Array<String>
    lateinit var detailImageList: Array<Int>
    private lateinit var myAdapter: AdapterClass
    private lateinit var searchView: SearchView
    private lateinit var searchList: ArrayList<DataClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        imageList = arrayOf(
            R.drawable.docotr,
            R.drawable.docotr,
            R.drawable.docotr,
            R.drawable.docotr,
            R.drawable.docotr,
            R.drawable.docotr,
            R.drawable.docotr,
            R.drawable.docotr,
            R.drawable.docotr,
            R.drawable.docotr,
            R.drawable.docotr,
            R.drawable.docotr,
            R.drawable.docotr

            )

        titleList = arrayOf(
            "Plastik ve Rekonstrüktif Cerrahi",
            "Çocuk Doktoru",
            "İç Hastalıkları",
            "Beyin ve Sinir Cerrahisi",
            "Genel Cerrahi",
            "Kalp ve Damar Cerrahisi",
            "Göğüs Hastalıkları",
            "Göz Doktoru",
            "Psikiyatri",
            "Kadın Hastalıkları ve Doğum",
            "Ortopedi ve Travmatoloji",
            "Dermatoloji",
            "Kulak Burun ve Boğaz",
            )

        descList = arrayOf(
            getString(R.string.ErenTuncer),
            getString(R.string.AliFuatSerpen),
            getString(R.string.CagdaSKara),
            getString(R.string.HakanYildirim),
            getString(R.string.SerapAlcicek),
            getString(R.string.SedaPamuk),
            getString(R.string.ArzuSoyhan),
            getString(R.string.MuratUyar),
            getString(R.string.ElifBaran),
            getString(R.string.BurakHazine),
            getString(R.string.FurkanArin),
            getString(R.string.MugeGoreKaarali),
            getString(R.string.BetulSahin))

        detailImageList = arrayOf(
            R.drawable.docotr,
            R.drawable.docotr,
            R.drawable.docotr,
            R.drawable.docotr,
            R.drawable.docotr,
            R.drawable.docotr,
            R.drawable.docotr,
            R.drawable.docotr,
            R.drawable.docotr,
            R.drawable.docotr,
            R.drawable.docotr,
            R.drawable.docotr,
            R.drawable.docotr
            )

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.search)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf<DataClass>()
        searchList = arrayListOf<DataClass>()
        getData()

        searchView.clearFocus()
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                searchList.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if (searchText.isNotEmpty()){
                    dataList.forEach{
                        if (it.dataTitle.toLowerCase(Locale.getDefault()).contains(searchText)) {
                            searchList.add(it)
                        }
                    }
                    recyclerView.adapter!!.notifyDataSetChanged()
                } else {
                    searchList.clear()
                    searchList.addAll(dataList)
                    recyclerView.adapter!!.notifyDataSetChanged()
                }
                return false
            }

        })

        myAdapter = AdapterClass(searchList)
        recyclerView.adapter = myAdapter

        myAdapter.onItemClick = {
            val intent = Intent(this, DetailedActivity::class.java)
            intent.putExtra("android", it)
            startActivity(intent)
        }

    }

    private fun getData(){
        for (i in imageList.indices){
            val dataClass = DataClass(imageList[i], titleList[i], descList[i], detailImageList[i])
            dataList.add(dataClass)
        }
        searchList.addAll(dataList)
        recyclerView.adapter = AdapterClass(searchList)

    }
}