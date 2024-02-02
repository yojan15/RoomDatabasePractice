package com.example.roomdatabasepractice.fragment

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabasepractice.data.Notes
import com.example.roomdatabasepractice.data.NotesViewModel
import com.example.roomdatabasepractice.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private lateinit var notesViewModel: NotesViewModel
    private lateinit var binding: FragmentAddBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =  FragmentAddBinding.inflate(inflater, container, false)
        notesViewModel = ViewModelProvider(this).get(NotesViewModel::class.java)
        binding.addNotes.setOnClickListener {
            insertDataToDatabase()
        }
        return binding.root
    }
    private fun insertDataToDatabase() {
        val title = binding.insertTitle.text.toString()
        val notes = binding.insertNote.text.toString()

        if(inputCheck(title , notes)) {
            val note = Notes(0,title , notes)
            notesViewModel.addNote(note)
            Log.e("Insert","$note")
            binding.insertTitle.text.clear()
            binding.insertNote.text.clear()
            Toast.makeText(requireContext(),"Note Added",Toast.LENGTH_SHORT).show()
        }
    }
    private fun inputCheck(title : String , notes : String) : Boolean {
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(notes))
    }

}