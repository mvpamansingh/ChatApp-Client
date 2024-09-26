package com.example.anonymousx.data.di

import com.example.anonymousx.data.remote.ChatApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

fun provideChatApi():ChatApi{


    return Retrofit.Builder()
        .baseUrl("http://192.168.1.5:3000")
        .addConverterFactory(GsonConverterFactory.create()).build().create(ChatApi::class.java)
}
val dataModule = module {

    single{
        provideChatApi()
    }
}