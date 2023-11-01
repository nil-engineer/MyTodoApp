package com.androiddev.mytodoapp.data.repositories

import com.androiddev.mytodoapp.data.TodoDao
import com.androiddev.mytodoapp.data.models.TodoTask
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TodoRepositoryImpl  @Inject constructor(private val todoDao: TodoDao): TodoRepository{
    val getAllTasks: Flow<List<TodoTask>> = todoDao.getAllTasks()
    val sortByLowPriority: Flow<List<TodoTask>> = todoDao.sortByLowPriority()
    val sortByHighPriority: Flow<List<TodoTask>> = todoDao.sortByHighPriority()
    override fun getSelectedTask(taskId: Int): Flow<TodoTask> {
        return todoDao.getSelectedTask(taskId)
    }

    override suspend fun addTask(todoTask: TodoTask) {
        todoDao.addTask(todoTask = todoTask)
    }

    override suspend fun updateTask(todoTask: TodoTask) {
        todoDao.updateTask(todoTask = todoTask)
    }

    override suspend fun deleteTask(todoTask: TodoTask) {
        todoDao.deleteTask(todoTask = todoTask)
    }

    override suspend fun deleteAllTasks() {
        todoDao.deleteAllTasks()
    }


}