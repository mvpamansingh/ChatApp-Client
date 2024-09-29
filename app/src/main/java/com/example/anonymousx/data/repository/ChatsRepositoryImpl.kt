package com.example.anonymousx.data.repository

import com.example.anonymousx.data.remote.ChatApi
import com.example.anonymousx.domain.model.Users
import com.example.anonymousx.domain.repository.ChatsRepository
import com.example.anonymousx.presentation.chatScreen.Message
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ChatsRepositoryImpl(
    val chatApi:ChatApi
):ChatsRepository {
    override suspend fun addUser(users: Users): Flow<Int> = flow {

        emit( chatApi.addUsers(users).code())
    }

    override suspend fun fetchUsers(): Flow<List<Users>> = flow{

        emit(chatApi.fetchUsers().body()!!)
    }

    override suspend fun sendMessage(message: Message) {

        chatApi.sendMessage(message)
    }
}