package com.example.anonymousx.presentation.navigation

import kotlinx.serialization.Serializable


@Serializable
data object AddUserScreen

@Serializable
data object MainScreen

@Serializable
data object UsersTab

@Serializable
data object GroupsTab

@Serializable
data object SettingsTab

// we use data object when the screen is taking data from another screens
// and if not we can use object


@Serializable
data class ChatScreen(
    val senderId:String,
    val receiverId:String
)
