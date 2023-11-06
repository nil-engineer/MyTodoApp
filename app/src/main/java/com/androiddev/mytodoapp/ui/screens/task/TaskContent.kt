package com.androiddev.mytodoapp.ui.screens.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.androiddev.mytodoapp.R
//import com.androiddev.mytodoapp.data.models.Priority

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskContent(
    modifier: Modifier,
    title: String,
    onTitleChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
//    priority: Priority,
//    onPrioritySelected: (Priority) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(all = 12.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = title,
            onValueChange = { onTitleChange(it) },
            label = { Text(text = stringResource(id = R.string.title)) },
            textStyle = MaterialTheme.typography.bodyLarge,
            singleLine = true
        )
        Divider(
            modifier = Modifier.height(8.dp),
            color = MaterialTheme.colorScheme.background
        )
//        PriorityDropDown(
//            priority = priority,
//            onPrioritySelected = onPrioritySelected
//        )
        OutlinedTextField(
            modifier = Modifier.fillMaxSize(),
            value = description,
            onValueChange = { onDescriptionChange(it) },
            label = { Text(text = stringResource(id = R.string.description)) },
            textStyle = MaterialTheme.typography.bodyLarge
        )
    }
}


@Composable
@Preview
private fun TaskContentPreview() {
    TaskContent(
        modifier = Modifier.padding(10.dp),
        title = "",
        onTitleChange = {},
        description = "",
        onDescriptionChange = {},
//        priority = Priority.LOW,
//        onPrioritySelected = {}
    )
}