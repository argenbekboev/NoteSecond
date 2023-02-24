package com.example.noteagain.domain.usecase

import com.example.noteagain.domain.model.Note
import com.example.noteagain.domain.repository.NoteRepository
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor
    (private val noteRepository: NoteRepository)
{
     fun getAllNotes() = noteRepository.getAllNotes()

}