package com.example.anonymousx.domain.repository

import com.example.anonymousx.domain.model.IndividualGroup
import com.example.anonymousx.domain.model.ReceivedGroupMessage
import com.example.anonymousx.domain.model.Users
import com.example.anonymousx.presentation.chatScreen.Message
import kotlinx.coroutines.flow.Flow

interface ChatsRepository {


    suspend fun addUser(users: Users):Flow<Int>

    suspend fun fetchUsers():Flow<List<Users>>





    suspend fun sendMessage(message: Message)
    suspend fun getMessages(chatRoomId:String):Flow<List<Message>>

    //Groups

    suspend fun getGroups():Flow<List<IndividualGroup>>
    suspend fun getGroupMessage(groupId:String):Flow<List<ReceivedGroupMessage>>
}