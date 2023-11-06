package com.androiddev.mytodoapp.ui.screens.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.androiddev.mytodoapp.R
import com.androiddev.mytodoapp.components.DisplayAlertDialog
import com.androiddev.mytodoapp.ui.viewmodels.SharedViewModel
import com.androiddev.mytodoapp.util.Action

@Composable
fun ListAppBar(
    sharedViewModel: SharedViewModel,
) {
    DefaultListAppBar(onDeleteAllConfirmed = {
        sharedViewModel.updateAction(newAction = Action.DELETE_ALL)
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultListAppBar(
    onDeleteAllConfirmed: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "Tasks",
                color = MaterialTheme.colorScheme.surface
            )
        },
        actions = {
            ListAppBarActions(
                onDeleteAllConfirmed = onDeleteAllConfirmed
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Composable
fun ListAppBarActions(
    onDeleteAllConfirmed: () -> Unit
) {
    var openDialog by remember { mutableStateOf(false) }

    DisplayAlertDialog(
        title = stringResource(id = R.string.delete_all_tasks),
        message = stringResource(id = R.string.delete_all_tasks_confirmation),
        openDialog = openDialog,
        closeDialog = { openDialog = false },
        onYesClicked = { onDeleteAllConfirmed() }
    )

    DeleteAllAction(onDeleteAllConfirmed = { openDialog = true })
}

//@Composable
//fun SearchAction(
//    onSearchClicked: () -> Unit
//) {
//    IconButton(onClick = { onSearchClicked() }) {
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = "Search Tasks",
//            tint = MaterialTheme.colorScheme.surface
//        )
//    }
//}

@Composable
fun DeleteAllAction(
    onDeleteAllConfirmed: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    IconButton(
        onClick = { expanded = true }
    ) {
        Icon(
            imageVector = Icons.Filled.MoreVert,
            contentDescription = stringResource(id = R.string.delete_all_action),
            tint = Color.White
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                onClick = {
                    expanded = false
                    onDeleteAllConfirmed()
                },
                text = {
                    Text(
                        modifier = Modifier.padding(start = 12.dp),
                        text = stringResource(id = R.string.delete_all_action),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            )
        }
    }

}

@Composable
@Preview
private fun DefaultListAppBarPreview() {
    DefaultListAppBar(
        onDeleteAllConfirmed = {}
    )
}