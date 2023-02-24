package com.example.noteagain.data.repository

import com.example.noteagain.data.base.BaseRepository
import com.example.noteagain.data.lacaldb.NoteDao
import com.example.noteagain.data.mapper.toEntity
import com.example.noteagain.data.mapper.toNote
import com.example.noteagain.domain.model.Note
import com.example.noteagain.domain.repository.NoteRepository
import com.example.noteagain.domain.utils.Resourse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
class NoteRepositoryImpl @Inject constructor ( private val noteDao: NoteDao):NoteRepository ,BaseRepository(){
    override fun createNote(note: Note) =doReguest {
        noteDao.createNote(note.toEntity())
    }

    override fun getAllNotes(): Flow<Resourse<List<Note>>> =doReguest {
        noteDao.getAllNotes().map { it.toNote() }
    }


    override fun editNote(note: Note)  = doReguest {
        noteDao.editNote(note.toEntity())
    }
    override fun deleteNote(note: Note) = doReguest {
        noteDao.deleteNote(note.toEntity())
    }

}
