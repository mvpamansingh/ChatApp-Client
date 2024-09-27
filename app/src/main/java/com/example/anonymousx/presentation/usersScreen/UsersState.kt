package com.example.anonymousx.presentation.usersScreen

import com.example.anonymousx.domain.model.Users

data class UsersState(
    val usersList: List<Users> = emptyList()
)
