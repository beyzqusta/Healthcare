package com.example.ilacc

import android.content.Context
import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.example.ilacc.databinding.IlacItemCellBinding
import java.time.format.DateTimeFormatter

class IlacItemViewHolder(
    private val context: Context,
    private val binding: IlacItemCellBinding,
    private val clickListener: IlacItemClickListener
): RecyclerView.ViewHolder(binding.root)
{
    private val timeFormat = DateTimeFormatter.ofPattern("HH:mm")

    fun bindTaskItem(ilacItem: IlacItem)
    {
        binding.name.text = ilacItem.name

        if (ilacItem.isCompleted()){
            binding.name.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            binding.dueTime.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        }

        binding.completeButton.setImageResource(ilacItem.imageResource())
        binding.completeButton.setColorFilter(ilacItem.imageColor(context))

        binding.completeButton.setOnClickListener{
            clickListener.ilacTamamlaItem(ilacItem)
        }
        binding.taskCellContainer.setOnClickListener{
            clickListener.ilacDuzenleItem(ilacItem)
        }

        if(ilacItem.dueTime != null)
            binding.dueTime.text = timeFormat.format(ilacItem.dueTime)
        else
            binding.dueTime.text = ""
    }
}