package com.example.noteagain.presentation.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.noteagain.domain.utils.UiState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseFragment:Fragment() {
    protected fun <T> StateFlow<UiState<T>>.collectState(
        onLoading: ()->Unit,
        Error:(message:String)-> Unit,
        onSuccess:(data:T) ->Unit
    ){
lifecycleScope.launch {
    repeatOnLifecycle(Lifecycle.State.STARTED) {
        this@collectState.collect { state ->
            when (state) {
                is UiState.Loading -> {
                    onLoading()
                }
                is UiState.Error -> {
                    Error(state.message)
                }
                is UiState.Success -> {
                    onSuccess(state.data)
                }
                is UiState.Empty -> {

                }
            }

        }
    }

}
    }
}