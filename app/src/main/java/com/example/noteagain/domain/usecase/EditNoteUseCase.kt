package com.example.noteagain.domain.usecase

import com.example.noteagain.domain.model.Note
import com.example.noteagain.domain.repository.NoteRepository
import javax.inject.Inject

class EditNoteUseCase @Inject constructor
    (private val noteRepository: NoteRepository)
{
    operator fun invoke(note: Note) = noteRepository.editNote(note)

}