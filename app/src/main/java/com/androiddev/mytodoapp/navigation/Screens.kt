package com.androiddev.mytodoapp.navigation

import androidx.navigation.NavHostController
import com.androiddev.mytodoapp.util.Action
import com.androiddev.mytodoapp.util.Constants.LIST_SCREEN

class Screens(navController: NavHostController) {
    val list: (Action) -> Unit = {action ->
        navController.navigate("list/${action.name}"){
            popUpTo(LIST_SCREEN){inclusive = true}
        }
    }

    val task: (Int) -> Unit = {taskId ->
        navController.navigate("task/$taskId")
    }
}