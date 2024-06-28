package com.example.ilacc

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

class IlacViewModel: ViewModel()
{
    var ilacItems = MutableLiveData<MutableList<IlacItem>>()

    init {
        ilacItems.value = mutableListOf()
    }

    fun ilacEkleItem(IlacItem: IlacItem)
    {
        val list = ilacItems.value
        list!!.add(IlacItem)
        ilacItems.postValue(list)
    }

    fun ilacGuncelleItem(id: UUID, name: String, desc: String, dueTime: LocalTime?)
    {
        val list = ilacItems.value
        val ilac = list!!.find { it.id == id }!!
        ilac.name = name
        ilac.desc = desc
        ilac.dueTime = dueTime
        ilacItems.postValue(list)
    }

    fun setCompleted(IlacItem: IlacItem)
    {
        val list = ilacItems.value
        val ilac = list!!.find { it.id == IlacItem.id }!!
        if (ilac.completedDate == null)
            ilac.completedDate = LocalDate.now()
        ilacItems.postValue(list)
    }
}