package com.example.anonymousx.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.anonymousx.presentation.add_user.AddUsersScreen


@Composable
fun SetUpnavGraph()
{
    val navController =  rememberNavController()

    NavHost(navController =navController , startDestination = AddUserScreen) {



        composable<AddUserScreen> {
            AddUsersScreen()
        }



    }
}