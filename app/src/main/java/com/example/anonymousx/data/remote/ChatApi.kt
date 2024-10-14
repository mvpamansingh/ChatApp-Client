package com.example.anonymousx.data.remote

import com.example.anonymousx.domain.model.IndividualGroup
import com.example.anonymousx.domain.model.Users
import com.example.anonymousx.presentation.chatScreen.Message
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ChatApi {

    @POST("addUser")
    suspend fun addUsers( @Body users: Users):Response<Users>





    @GET("getusers")
    suspend fun fetchUsers():Response<List<Users>>

    @POST("send-messsage")
    suspend fun sendMessage(@Body message: Message): Response<Message>

    @GET("messages/{chatRoomId}")
    suspend fun getMessages(
        @Path("chatRoomId") chatRoomId:String
    ):Response<List<Message>>


    // Groups

    @GET("get-groups")
    suspend fun getGrouups():Response<List<IndividualGroup>>
}