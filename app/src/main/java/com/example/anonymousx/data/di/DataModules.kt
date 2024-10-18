package com.example.anonymousx.data.di

import com.example.anonymousx.data.remote.ChatApi
import com.example.anonymousx.data.repository.ChatsRepositoryImpl
import com.example.anonymousx.domain.repository.ChatsRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

fun provideChatApi():ChatApi{


    return Retrofit.Builder()
        .baseUrl("http://192.168.97.20:3000")
        .addConverterFactory(GsonConverterFactory.create()).build().create(ChatApi::class.java)
}



fun provideChatsRepository(chatApi: ChatApi):ChatsRepository{
    return ChatsRepositoryImpl(chatApi)
}
val dataModule = module {

    single{
        provideChatApi()
    }

    single{
        provideChatsRepository(get())
    }
}