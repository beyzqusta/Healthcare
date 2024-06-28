package com.example.ilacc.com.example.ilacc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.ilacc.R

class PolAdapter(private var mList:List<PolData>):
    RecyclerView.Adapter<PolAdapter.LanguageViewHolder>(){

    inner class LanguageViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val polLogo:ImageView=itemView.findViewById(R.id.polLogo)
        val polBaslik:TextView=itemView.findViewById(R.id.polBaslik)
        val polDetay:TextView=itemView.findViewById(R.id.polDetay)
        val constraintLayout:ConstraintLayout=itemView.findViewById(R.id.constraintLayout)


        fun collapseExpandedView(){
            polDetay.visibility=View.GONE
        }
    }

    fun setFilteredList(mList: List<PolData>){
        this.mList=mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return LanguageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {

        val poliklinikData=mList[position]
        holder.polLogo.setImageResource(poliklinikData.logo)
        holder.polBaslik.text=poliklinikData.baslik
        holder.polDetay.text=poliklinikData.aciklama

        val isExpandable:Boolean=poliklinikData.isExpandable
        holder.polDetay.visibility= if (isExpandable) View.VISIBLE else View.GONE

        holder.constraintLayout.setOnClickListener{
            isAnyItemExpanded(position)
            poliklinikData.isExpandable= !poliklinikData.isExpandable
            notifyItemChanged(position, Unit)
        }

    }

    private fun isAnyItemExpanded(position: Int){
        val temp=mList.indexOfFirst {
            it.isExpandable
        }

        if (temp>=0 && temp != position){
            mList[temp].isExpandable=false
            notifyItemChanged(temp,0)
        }
    }

    override fun onBindViewHolder(
        holder: LanguageViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isNotEmpty() && payloads[0] == 0) {
            holder.collapseExpandedView()
        } else {
            super.onBindViewHolder(holder, position, payloads)
            }
        }
}