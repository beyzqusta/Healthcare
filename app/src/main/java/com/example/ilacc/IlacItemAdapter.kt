package com.example.ilacc

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ilacc.databinding.IlacItemCellBinding

class IlacItemAdapter(
    private val ilacItems: List<IlacItem>,
    private val clickListener: IlacItemClickListener
): RecyclerView.Adapter<IlacItemViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IlacItemViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = IlacItemCellBinding.inflate(from, parent, false)
        return IlacItemViewHolder(parent.context, binding, clickListener)
    }

    override fun onBindViewHolder(holder: IlacItemViewHolder, position: Int) {
        holder.bindTaskItem(ilacItems[position])
    }

    override fun getItemCount(): Int = ilacItems.size
}