package com.androiddev.mytodoapp.data.repositories

import com.androiddev.mytodoapp.data.TodoDao
import com.androiddev.mytodoapp.data.models.TodoTask
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class TodoRepository @Inject constructor(private val todoDao: TodoDao){

    fun getAllTasks(): Flow<List<TodoTask>> {
        return todoDao.getAllTasks()
    }

//    fun sortByLowPriority(): Flow<List<TodoTask>> {
//        return todoDao.sortByLowPriority()
//    }
//
//    fun sortByHighPriority(): Flow<List<TodoTask>> {
//        return todoDao.sortByHighPriority()
//    }

    fun getSelectedTask(taskId: Int): Flow<TodoTask> {
        return todoDao.getSelectedTask(taskId)
    }

    suspend fun addTask(todoTask: TodoTask) {
        todoDao.addTask(todoTask = todoTask)
    }

    suspend fun updateTask(todoTask: TodoTask) {
        todoDao.updateTask(todoTask = todoTask)
    }

    suspend fun deleteTask(todoTask: TodoTask) {
        todoDao.deleteTask(todoTask = todoTask)
    }

    suspend fun deleteAllTasks() {
        todoDao.deleteAllTasks()
    }


}