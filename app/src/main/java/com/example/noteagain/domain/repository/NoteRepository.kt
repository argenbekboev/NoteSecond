package com.example.noteagain.domain.repository

import com.example.noteagain.domain.model.Note
import com.example.noteagain.domain.utils.Resourse
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun createNote(note: Note):Flow<Resourse<Unit>>

     fun getAllNotes():Flow<Resourse<List<Note>>>

    fun editNote(note: Note):Flow<Resourse<Unit>>

    fun deleteNote(note: Note):Flow<Resourse<Unit>>
}