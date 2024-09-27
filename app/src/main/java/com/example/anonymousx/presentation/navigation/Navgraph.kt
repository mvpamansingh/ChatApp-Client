package com.example.anonymousx.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.anonymousx.presentation.add_user.AddUserViewModel
import com.example.anonymousx.presentation.add_user.AddUsersScreen
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



    }
}