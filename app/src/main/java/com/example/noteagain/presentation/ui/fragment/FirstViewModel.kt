package com.example.noteagain.presentation.ui.fragment

import com.example.noteagain.domain.model.Note
import com.example.noteagain.domain.usecase.DeleteNoteUseCase
import com.example.noteagain.domain.usecase.GetAllNotesUseCase
import com.example.noteagain.domain.utils.UiState
import com.example.noteagain.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
):BaseViewModel() {


    private val _getAllNotesUseCase = MutableStateFlow<UiState<List<Note>>>(UiState.Empty())
    val getAllNoteState = _getAllNotesUseCase.asStateFlow()


    private val _deleteNoteUseCase = MutableStateFlow<UiState<Unit>>(UiState.Empty())
    val deleteNoteState = _deleteNoteUseCase.asStateFlow()


    fun getAllNotes() {
        getAllNotesUseCase.getAllNotes().collectFlow(_getAllNotesUseCase)
    }

    fun deleteNote(note: Note) {
        deleteNoteUseCase(note).collectFlow(_deleteNoteUseCase)
    }
}