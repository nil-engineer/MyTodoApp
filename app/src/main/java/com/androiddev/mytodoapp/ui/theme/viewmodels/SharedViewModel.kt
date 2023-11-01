package com.androiddev.mytodoapp.ui.theme.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiddev.mytodoapp.data.models.TodoTask
import com.androiddev.mytodoapp.data.repositories.TodoRepository
import com.androiddev.mytodoapp.util.Action
import com.androiddev.mytodoapp.util.Constants.MAX_TITLE_LENGTH
import com.androiddev.mytodoapp.util.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
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

    private val _selectedTask: MutableStateFlow<TodoTask?> = MutableStateFlow(null)
    val selectedTask: StateFlow<TodoTask?> = _selectedTask
    var id by mutableIntStateOf(0)
        private set
    var title by mutableStateOf("")
        private set
    var description by mutableStateOf("")
        private set

    var action by mutableStateOf(Action.NO_ACTION)
        private set
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

    fun getSelectedTask(taskId: Int) {
        viewModelScope.launch {
            repository.getSelectedTask(taskId = taskId).collect { task ->
                _selectedTask.value = task
            }
        }
    }

    private fun addTask() {
        viewModelScope.launch(Dispatchers.IO) {
            val toDoTask = TodoTask(
                title = title,
                description = description,
//                priority = priority
            )
            repository.addTask(todoTask = toDoTask)
        }
//        searchAppBarState = SearchAppBarState.CLOSED
    }

    fun updateTaskFields(selectedTask: TodoTask?) {
        if (selectedTask != null) {
            id = selectedTask.id
            title = selectedTask.title
            description = selectedTask.description
//            priority = selectedTask.priority
        } else {
            id = 0
            title = ""
            description = ""
//            priority = Priority.LOW
        }
    }

    fun updateTitle(newTitle: String) {
        if (newTitle.length < MAX_TITLE_LENGTH) {
            title = newTitle
        }
    }

    fun updateDescription(newDescription: String) {
        description = newDescription
    }

    fun updateAction(newAction: Action) {
        action = newAction
    }

    fun validateFields(): Boolean {
        return title.isNotEmpty() && description.isNotEmpty()
    }
}