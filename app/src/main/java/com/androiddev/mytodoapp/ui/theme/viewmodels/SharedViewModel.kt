package com.androiddev.mytodoapp.ui.theme.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiddev.mytodoapp.data.models.TodoTask
import com.androiddev.mytodoapp.data.repositories.TodoRepository
import com.androiddev.mytodoapp.util.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: TodoRepository
) : ViewModel() {

    private val _allTasks = MutableStateFlow<RequestState<List<TodoTask>>>(RequestState.Idle)
    val allTasks: StateFlow<RequestState<List<TodoTask>>> = _allTasks
    fun getAllTasks() {
        _allTasks.value = RequestState.Loading
        try{
            viewModelScope.launch {
                repository.getAllTasks().collect {
                    _allTasks.value = RequestState.Success(it)
                }
            }
        }
        catch (e: Exception){
            _allTasks.value = RequestState.Error(e)
        }

    }
}