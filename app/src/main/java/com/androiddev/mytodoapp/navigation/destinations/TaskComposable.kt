package com.androiddev.mytodoapp.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.androiddev.mytodoapp.util.Action
import com.androiddev.mytodoapp.util.Constants.LIST_ARGUMENT_KEY
import com.androiddev.mytodoapp.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (Action) -> Unit
){
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY){
            type = NavType.IntType
        })
    ){

    }
}