package com.androiddev.mytodoapp.navigation

import androidx.navigation.NavHostController
import com.androiddev.mytodoapp.util.Action
import com.androiddev.mytodoapp.util.Constants.LIST_SCREEN

class Screens(navController: NavHostController) {

    val list: (Int) -> Unit = { taskId ->
        navController.navigate(route = "task/$taskId")
    }
    val task: (Action) -> Unit = { action ->
        navController.navigate(route = "list/${action}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }
}