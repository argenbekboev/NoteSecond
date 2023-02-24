package com.example.noteagain.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteagain.domain.utils.Resourse
import com.example.noteagain.domain.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
abstract class BaseViewModel:ViewModel() {
    protected fun <T> Flow<Resourse<T>>.collectFlow(_state:MutableStateFlow<UiState<T>>){
        viewModelScope.launch(Dispatchers.IO) {
            this@collectFlow.collect{result->
                when(result){
                    is Resourse.Loading -> {
                        _state.value = UiState.Loading()
                    }
                    is Resourse.Success -> {
                        if (result.data != null) {
                            _state.value = UiState.Success(result.data)
                        }
                    }
                    is Resourse.Error -> {
                        _state.value = UiState.Error(result.message!!)
                    }
                }
                }

            }

    }
  /*  protected fun <T>  T.state(_usecase: MutableStateFlow<UiState<T>>){
        this@state.MutableStateFlow<UiState<T>>(UiState.Empty())
_usecase.asStateFlow()
    }*/
}