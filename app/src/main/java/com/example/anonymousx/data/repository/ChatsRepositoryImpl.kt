package com.example.anonymousx.data.repository

import android.util.Log
import com.example.anonymousx.data.prefrences.UserPreferences
import com.example.anonymousx.data.remote.ChatApi
import com.example.anonymousx.domain.model.IndividualGroup
import com.example.anonymousx.domain.model.ReceivedGroupMessage
import com.example.anonymousx.domain.model.ReceivedUserInfo
import com.example.anonymousx.domain.model.SentGroupMessage
import com.example.anonymousx.domain.model.SignUpSigIn
import com.example.anonymousx.domain.model.Users
import com.example.anonymousx.domain.repository.ChatsRepository
import com.example.anonymousx.presentation.chatScreen.Message
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ChatsRepositoryImpl(
    val chatApi:ChatApi,
     val userPreferences: UserPreferences
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

    override suspend fun getMessages(chatRoomId: String): Flow<List<Message>> = flow {


        try{
            emit(chatApi.getMessages(chatRoomId).body()!!)

        }
        catch (e:Exception)
        {
            Log.d("Exception", e.message.toString())
        }
    }

    override suspend fun getGroups(): Flow<List<IndividualGroup>> = flow {
        emit(chatApi.getGrouups().body()!!)
    }

    override suspend fun getGroupMessage(groupId:String): Flow<List<ReceivedGroupMessage>> = flow {

        try {
            emit(chatApi.getGroupMessage(groupId).body()!!)
        }
        catch(e : Exception){
            Log.d("Exception", e.message.toString())
        }
    }

    override suspend fun sendGroupMessage(sentGroupMessage: SentGroupMessage) {

        chatApi.sendGroupMessage(sentGroupMessage)
    }

    override suspend fun createNewGroup(individualGroup: IndividualGroup) {

            chatApi.createNewGroup(individualGroup)
        }


    override suspend fun signIn(signUpSigIn: SignUpSigIn): Flow<ReceivedUserInfo> = flow {
        try {
            val response = chatApi.signIn(signUpSigIn)
            if (response.isSuccessful) {
                val userInfo = response.body()
                userInfo?.let {
                    // Save user info to DataStore
                    userPreferences.saveUserInfo(it)
                    emit(it)
                } ?: throw Exception("User info is null")
            } else {
                throw Exception("Sign in failed: ${response.message()}")
            }
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun signUp(signUpSigIn: SignUpSigIn) {
        chatApi.signUp(signUpSigIn)
    }


}