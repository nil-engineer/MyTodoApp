package com.androiddev.mytodoapp.di

import com.androiddev.mytodoapp.data.repositories.TodoRepository
import com.androiddev.mytodoapp.data.repositories.TodoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindTodoRepository(todoRepositoryImpl: TodoRepositoryImpl): TodoRepository
}