package com.example.anonymousx.data.repository

import com.example.anonymousx.data.remote.ChatApi
import com.example.anonymousx.domain.model.Users
import com.example.anonymousx.domain.repository.ChatsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ChatsRepositoryImpl(
    val chatApi:ChatApi
):ChatsRepository {
    override suspend fun addUser(users: Users): Flow<Int> = flow {

        emit( chatApi.addUsers(users).code())
    }
}