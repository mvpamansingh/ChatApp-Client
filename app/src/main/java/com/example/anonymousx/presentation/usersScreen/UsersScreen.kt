package com.example.anonymousx.presentation.usersScreen

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
import com.example.anonymousx.domain.model.Users
import com.example.anonymousx.presentation.usersScreen.components.UserAppBar
import com.example.anonymousx.presentation.usersScreen.components.UserItem


@Composable
fun UsersScreen(
    modifier: Modifier= Modifier,
    state: UsersState,
    event: (UserEvent)->Unit,
    onClick :(String)->Unit
)
{
    LaunchedEffect(key1 = Unit) {
        event(UserEvent.FetchUserList)
    }



    Column(modifier =Modifier.fillMaxSize()) {

        UserAppBar("Users")
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn(
            modifier= Modifier
                .padding(horizontal = 12.dp)
                .fillMaxSize()
        ) {
            items(state.usersList) { user->



                UserItem(
                    user,
                    onClick =  {
                        onClick(user._id.toString())
                    }
                )
            }
        }
    }
}

//val listt = listOf(
//    Users(username = "Aman"),Users(username = "Shiv"),
//    //"Aman", "Shiv"
//)