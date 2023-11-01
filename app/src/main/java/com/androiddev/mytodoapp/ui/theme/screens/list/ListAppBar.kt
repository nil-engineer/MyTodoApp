package com.androiddev.mytodoapp.ui.theme.screens.list

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ListAppBar() {
    DefaultListAppBar()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultListAppBar() {
    TopAppBar(
        title = {
            Text(
                text = "Tasks",
                color = MaterialTheme.colorScheme.surface
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}

//@Composable
//fun ListAppBarActions() {
//
//}

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
@Preview
private fun DefaultListAppBarPreview() {
    DefaultListAppBar()
}