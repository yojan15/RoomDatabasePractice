package com.example.roomdatabasepractice.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NotesDao {
    @Insert
   suspend fun insertNote(notes: Notes)
    @Update
   suspend fun updateNote(notes: Notes)
   @Delete
   suspend fun deleteNotes(notes: Notes)
   @Query("select * from notes order by id desc")
   fun getAllNotes() : LiveData<List<Notes>>

}