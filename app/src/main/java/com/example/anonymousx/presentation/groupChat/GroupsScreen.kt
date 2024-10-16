package com.example.anonymousx.presentation.groupChat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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



    Column(modifier = Modifier.fillMaxSize()) {

        UserAppBar("Users")
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn(
            modifier= Modifier
                .padding(horizontal = 12.dp)
                .fillMaxSize()
        ) {
            items(state.groupsList) { user->



                GroupItem(
                    user,
                    onClick =  {
                        onClick(user._id.toString())
                    }
                )
            }
        }
    }
}

val listt = listOf(
    IndividualGroup(name = "Grp 1"), IndividualGroup(name = "Shiv"),
    //"Aman", "Shiv"
)