package com.example.ilacc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ilacc.com.example.ilacc.PolAdapter
import com.example.ilacc.com.example.ilacc.PolData
import java.util.Locale

class MainActivity3 : AppCompatActivity() {

    private lateinit var recyclerView:RecyclerView
    private lateinit var searchView: SearchView
    private var mList=ArrayList<PolData>()
    private lateinit var adapter: PolAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        recyclerView=findViewById(R.id.recyclerView)
        searchView=findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager=LinearLayoutManager(this)
        addDataToList()
        adapter= PolAdapter(mList)
        recyclerView.adapter=adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?):Boolean{
                return false
            }
            override fun onQueryTextChange(newText: String?) :Boolean{
                filterList(newText)
                return true
            }
        })
    }

    private fun filterList(query: String?){

        if(query!=null){
            val filteredList=ArrayList<PolData>()
            for(i in mList){
                if(i.baslik.lowercase(Locale.ROOT).contains(query)){
                    filteredList.add(i)
                }
            }

            if(filteredList.isEmpty()){
                Toast.makeText(this, "Poliklinik bulunamadı!", Toast.LENGTH_SHORT).show()
            }else{
                adapter.setFilteredList(filteredList)
            }
        }
    }

    private fun addDataToList(){
        mList.add(PolData("Göz Polikliniği", R.drawable.goz, "18.06.2022\nMiyop, Hipermetropi ve Astigmatizm tanısı konulmuştur.\nGözlük reçete edilmiştir."))
        mList.add(PolData("İç Hastalıkları Polikliniği", R.drawable.dahiliye, "05.07.2022 \nSoğuk algınlığı ve grip tanısı konulmuştur.\nHap reçete edilmiştir."))
        mList.add(PolData("Psikiyatri Polikliniği", R.drawable.psikoloji, "25.11.2023\nDepresyon ve kaygı bozukluğu tanısı konulmuştur.\n---"))
        mList.add(PolData("Plastik Cerrahi Polikliniği", R.drawable.plastik, "02.01.2023\nEstetik operasyon gerçekleştirilmiştir.\n---"))
        mList.add(PolData("Beyin-Sinir Cerrahisi Polikliniği", R.drawable.beyin, "---\nGeçmiş tanınız bulunmamaktadır.\n---"))
        mList.add(PolData("Göğüs Hastalıkları Polikliniği", R.drawable.gogus_cerrahi, "17.11.2022\nAlerjik astım tansı konulmuştur.\nAstım ilacı reçete edilmiştir."))
    }
}