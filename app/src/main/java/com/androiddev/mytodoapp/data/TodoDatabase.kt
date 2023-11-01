package com.androiddev.mytodoapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.androiddev.mytodoapp.data.models.TodoDao
import com.androiddev.mytodoapp.data.models.TodoTask

@Database(entities = [TodoTask::class], version = 1, exportSchema = false)
abstract class TodoDatabase: RoomDatabase() {
    abstract fun todoDao(): TodoDao
}