package com.example.anonymousx.data.di

import android.content.Context
import com.example.anonymousx.data.prefrences.UserPreferences
import com.example.anonymousx.data.remote.ChatApi
import com.example.anonymousx.data.repository.ChatsRepositoryImpl
import com.example.anonymousx.domain.repository.ChatsRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

fun provideChatApi():ChatApi{


    return Retrofit.Builder()
        .baseUrl("http://192.168.1.5:3000")
        .addConverterFactory(GsonConverterFactory.create()).build().create(ChatApi::class.java)
}

fun provideUserPreferences(context: Context): UserPreferences {
    return UserPreferences(context)
}

fun provideChatsRepository(chatApi: ChatApi,userPreferences: UserPreferences ):ChatsRepository{
    return ChatsRepositoryImpl(chatApi, userPreferences)
}


val dataModule = module {

    single{
        provideChatApi()
    }

    single{
        provideChatsRepository(get(), get())
    }

    single{
        provideUserPreferences(androidContext())
    }
}