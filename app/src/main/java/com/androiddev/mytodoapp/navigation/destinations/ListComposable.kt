package com.androiddev.mytodoapp.navigation.destinations

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.androiddev.mytodoapp.ui.screens.list.ListScreen
import com.androiddev.mytodoapp.ui.theme.viewmodels.SharedViewModel
import com.androiddev.mytodoapp.util.Action
import com.androiddev.mytodoapp.util.Constants.LIST_ARGUMENT_KEY
import com.androiddev.mytodoapp.util.Constants.LIST_SCREEN
import com.androiddev.mytodoapp.util.toAction

fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
){
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY){
            type = NavType.StringType
        })
    ){
            navBackStackEntry ->
        val action = navBackStackEntry.arguments?.getString(LIST_ARGUMENT_KEY).toAction()

        var myAction by rememberSaveable { mutableStateOf(Action.NO_ACTION) }

        LaunchedEffect(key1 = myAction) {
            if(action != myAction){
                myAction = action
                sharedViewModel.updateAction(newAction = action)
            }
        }

        val databaseAction = sharedViewModel.action
        ListScreen(navigateToTaskScreen = navigateToTaskScreen,
            sharedViewModel = sharedViewModel)
    }
}