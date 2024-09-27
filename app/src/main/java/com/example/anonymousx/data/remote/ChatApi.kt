package com.example.anonymousx.data.remote

import com.example.anonymousx.domain.model.Users
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ChatApi {

    @POST("addUser")
    suspend fun addUsers( @Body users: Users):Response<Users>





    @GET("getusers")
    suspend fun fetchUsers():Response<List<Users>>
}