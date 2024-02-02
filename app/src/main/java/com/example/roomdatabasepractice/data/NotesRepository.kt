package com.example.roomdatabasepractice.data

import androidx.lifecycle.LiveData

class NotesRepository(private val noteDao : NotesDao) {
    /*
    * A repository class abstracts access to multiple data sources*/

    val readAllData : LiveData<List<Notes>> = noteDao.getAllNotes()

    suspend fun addNotes(notes: Notes) {
        noteDao.insertNote(notes)
    }

}