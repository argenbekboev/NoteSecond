package com.example.noteagain.data.mapper

import com.example.noteagain.data.model.NoteEntity
import com.example.noteagain.domain.model.Note


fun Note.toEntity()=NoteEntity(
    id,
    title,
    description,
    create
)
fun NoteEntity.toNote()=Note(
    id,
    title,
    description,
    create
)