package com.example.anonymousx.presentation.groupChat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.anonymousx.domain.model.IndividualGroup
import com.example.anonymousx.presentation.usersScreen.components.UserAppBar
import com.example.anonymousx.presentation.usersScreen.components.UserItem


@Composable
fun GroupsScreen(
    modifier: Modifier = Modifier,
    state: GroupsScreenState,
    event: (GroupsScreenEvent)->Unit,
    onClick :(String)->Unit
)
{
    LaunchedEffect(key1 = Unit) {
        event(GroupsScreenEvent.FetchGroupsList)
    }


    var showDialog by remember { mutableStateOf(false) }
    var newGroupName by remember { mutableStateOf("") }


    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { showDialog=true }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Create group")
            }
        }
    ) {innerPadding->


        Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {

            UserAppBar("Groups")
            Spacer(modifier = Modifier.height(10.dp))
            LazyColumn(
                modifier= Modifier
                    .padding(horizontal = 12.dp)
                    .fillMaxSize()
            ) {
                items(state.groupsList) { group->



                    GroupItem(
                        group,
                        onClick =  {
                            onClick(group._id.toString())
                        }
                    )
                }
            }
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Create Group") },
            text = {
                OutlinedTextField(
                    value = newGroupName,
                    onValueChange = { newGroupName = it },
                    label = { Text("Group Name") }
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        if (newGroupName.isNotBlank()) {
                            val input = IndividualGroup(name = newGroupName)
                            event(GroupsScreenEvent.CreateNewGroup(input))
                            newGroupName = ""
                            showDialog = false
                        }
                    }
                ) {
                    Text("Create")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showDialog = false }
                ) {
                    Text("Cancel")
                }
            }
        )
    }

}


val listt = listOf(
    IndividualGroup(name = "Grp 1"), IndividualGroup(name = "Shiv"),
    //"Aman", "Shiv"
)