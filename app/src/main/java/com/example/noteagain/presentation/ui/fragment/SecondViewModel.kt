package com.example.noteagain.presentation.ui.fragment

import com.example.noteagain.domain.model.Note
import com.example.noteagain.domain.usecase.CreateNoteUseCase
import com.example.noteagain.domain.usecase.EditNoteUseCase
import com.example.noteagain.domain.utils.UiState
import com.example.noteagain.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SecondViewModel @Inject constructor (
    private val editNoteUseCase: EditNoteUseCase,
    private val createNoteUseCase: CreateNoteUseCase
):BaseViewModel(){

    private val _createNoteState = MutableStateFlow<UiState<Unit>>(UiState.Empty())
    val createNoteState = _createNoteState.asStateFlow()

    private val _editNoteUseCase = MutableStateFlow<UiState<Unit>>(UiState.Empty())
    val editNoteState = _editNoteUseCase.asStateFlow()

    fun createNote(note: Note) {
        createNoteUseCase(note).collectFlow(_createNoteState)
    }
    fun editNote(note: Note) {
        editNoteUseCase(note).collectFlow(_editNoteUseCase)

    }

}