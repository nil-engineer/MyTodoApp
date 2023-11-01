package com.androiddev.mytodoapp.data.repositories

import com.androiddev.mytodoapp.data.models.TodoTask
import kotlinx.coroutines.flow.Flow

interface TodoRepository{

    fun getSelectedTask(taskId: Int): Flow<TodoTask>

    suspend fun addTask(todoTask: TodoTask)

    suspend fun updateTask(todoTask: TodoTask)

    suspend fun deleteTask(todoTask: TodoTask)
    suspend fun deleteAllTasks()


}