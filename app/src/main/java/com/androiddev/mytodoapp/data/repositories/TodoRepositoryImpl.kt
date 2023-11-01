package com.androiddev.mytodoapp.data.repositories

import com.androiddev.mytodoapp.data.TodoDao
import com.androiddev.mytodoapp.data.models.TodoTask
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class TodoRepositoryImpl @Inject constructor(private val todoDao: TodoDao) : TodoRepository {
    override fun getAllTasks(): Flow<List<TodoTask>> {
        return todoDao.getAllTasks()
    }

    override fun sortByLowPriority(): Flow<List<TodoTask>> {
        return todoDao.sortByLowPriority()
    }

    override fun sortByHighPriority(): Flow<List<TodoTask>> {
        return todoDao.sortByHighPriority()
    }

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