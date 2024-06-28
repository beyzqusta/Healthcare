package com.example.ilacc

import android.app.TimePickerDialog
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.ilacc.databinding.FragmentNewIlacSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.time.LocalTime

class NewIlacSheet(var ilacItem: IlacItem?) : BottomSheetDialogFragment()
{
    private lateinit var binding: FragmentNewIlacSheetBinding
    private lateinit var ilacViewModel: IlacViewModel
    private var dueTime: LocalTime? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()

        if (ilacItem != null)
        {
            binding.taskTitle.text = "Hatırlatıcıyı Düzenle"
            val editable = Editable.Factory.getInstance()
            binding.name.text = editable.newEditable(ilacItem!!.name)
            binding.desc.text = editable.newEditable(ilacItem!!.desc)
            if(ilacItem!!.dueTime != null){
                dueTime = ilacItem!!.dueTime!!
                updateTimeButtonText()
            }
        }
        else
        {
            binding.taskTitle.text = "Yeni Hatırlatıcı"
        }

        ilacViewModel = ViewModelProvider(activity).get(IlacViewModel::class.java)
        binding.saveButton.setOnClickListener {
            saveAction()
        }
        binding.timePickerButton.setOnClickListener {
            openTimePicker()
        }
    }

    private fun openTimePicker() {
        if(dueTime == null)
            dueTime = LocalTime.now()
        val listener = TimePickerDialog.OnTimeSetListener{ _, selectedHour, selectedMinute ->
            dueTime = LocalTime.of(selectedHour, selectedMinute)
            updateTimeButtonText()
        }
        val dialog = TimePickerDialog(activity, listener, dueTime!!.hour, dueTime!!.minute, true)
        dialog.setTitle("Hatırlatıcı")
        dialog.show()

    }

    private fun updateTimeButtonText() {
        binding.timePickerButton.text = String.format("%02d:%02d",dueTime!!.hour,dueTime!!.minute)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNewIlacSheetBinding.inflate(inflater,container,false)
        return binding.root
    }


    private fun saveAction()
    {
        val name = binding.name.text.toString()
        val desc = binding.desc.text.toString()
        if(ilacItem == null)
        {
            val yeniIlac = IlacItem(name,desc,dueTime,null)
            ilacViewModel.ilacEkleItem(yeniIlac)
        }
        else
        {
            ilacViewModel.ilacGuncelleItem(ilacItem!!.id, name, desc, dueTime)
        }
        binding.name.setText("")
        binding.desc.setText("")
        dismiss()
    }

}







