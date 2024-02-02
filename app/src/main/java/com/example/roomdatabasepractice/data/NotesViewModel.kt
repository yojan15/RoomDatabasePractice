package com.example.roomdatabasepractice.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(application: Application) :AndroidViewModel(application) {
    fun addNote(notes: Notes) {
        viewModelScope.launch(Dispatchers.IO) { repository.addNotes(notes) }
    }
    /*
    * the viewModel role is to provide data to the ui and survive configuration changes,.
    * A viewModel acts as a communication center between the repository and the ui
    * */
     val readAllData : LiveData<List<Notes>>
    private val repository : NotesRepository
    init {
        val notesDao = NotesDatabase.getDatabase(application).noteDao()
        repository = NotesRepository(notesDao)
        readAllData = repository.readAllData


    }
}