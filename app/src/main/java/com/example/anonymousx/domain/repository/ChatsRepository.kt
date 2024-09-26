package com.example.anonymousx.domain.repository

import com.example.anonymousx.domain.model.Users
import kotlinx.coroutines.flow.Flow

interface ChatsRepository {


    suspend fun addUser(users: Users):Flow<Int>
}