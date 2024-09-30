package com.example.anonymousx.presentation.chatScreen

import android.os.Message
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.anonymousx.R
import com.example.anonymousx.presentation.usersScreen.components.UserAppBar

@Composable
fun ChatScreen(
    navController:NavController,
    senderId:String,
    receiverId:String,
    events: (ChatsEvents)->Unit //<<
    , states: ChatStates
)
{




    Column(
        modifier= Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .background(color = colorResource(id = R.color.teal_700))

    ) {

        UserAppBar("Chats")

        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn(modifier= Modifier.fillMaxWidth().weight(1f),
            reverseLayout = false
        ) {

            items(states.messageist)
            {message->

                MessageBox(
                    message= message,

                )
            }

        }

        MessageInputField()
        {message->
                val messagee = Message(
                    message = message,
                    senderId = senderId,
                    receiverId = receiverId
                )
            events(ChatsEvents.SendMessage(messagee))
        }
    }
}