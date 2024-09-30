package com.example.anonymousx.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.anonymousx.presentation.add_user.AddUserViewModel
import com.example.anonymousx.presentation.add_user.AddUsersScreen
import com.example.anonymousx.presentation.chatScreen.ChatScreen
import com.example.anonymousx.presentation.chatScreen.ChatViewModel
import com.example.anonymousx.presentation.usersScreen.UserViewModel
import com.example.anonymousx.presentation.usersScreen.UsersScreen
import org.koin.androidx.compose.koinViewModel


@Composable
fun SetUpnavGraph()
{
    val navController =  rememberNavController()

    NavHost(navController =navController , startDestination = AddUserScreen) {



        composable<AddUserScreen> {

            val viewModel:AddUserViewModel = koinViewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()
            AddUsersScreen(state= state,
                event = viewModel::onEvent, navController = navController )
        }

        composable<UserScreen> {




            val viewModel:UserViewModel = koinViewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()


            UsersScreen(
                state= state,
                event = viewModel::onEvent
            )
            {receiverId->
                    navController.navigate(ChatScreen(
                        receiverId = receiverId,
                        senderId = "66f6251740d285204dee80f7"
                    ))
            }
        }

        composable<ChatScreen> {
            val args = it.toRoute<ChatScreen>()

            val viewModel:ChatViewModel = koinViewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()
            
            LaunchedEffect(key1 = Unit) {
                viewModel.getMessages(createChatRoomId(args.receiverId,args.senderId))
            }
            ChatScreen(
                navController = navController,
                senderId = args.senderId,
                receiverId = args.receiverId,
                events = viewModel::onEvent,



                states = state
            )
        }

    }
}

fun createChatRoomId(id1:String, id2:String):String
{
    val ids = listOf(id1,id2).sorted()
    return ids.joinToString(separator = "_")
}