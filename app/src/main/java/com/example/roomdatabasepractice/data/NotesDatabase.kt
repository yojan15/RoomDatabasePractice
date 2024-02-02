package com.example.roomdatabasepractice.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Notes::class], version = 1)
abstract class NotesDatabase :RoomDatabase() {
    abstract fun noteDao() : NotesDao
    companion object {
        @Volatile
        private var INSTANCE : NotesDatabase? = null
        fun getDatabase(context: Context) : NotesDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,
                    NotesDatabase::class.java,"noteDatabase").build()
                INSTANCE = instance
                return instance
            }
        }
     }
}