package com.example.noteagain.data.lacaldb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.noteagain.data.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDataBase : RoomDatabase() {

    abstract fun noteDao():NoteDao

}