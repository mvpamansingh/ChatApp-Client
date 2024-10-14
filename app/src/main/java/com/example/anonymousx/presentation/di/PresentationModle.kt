package com.example.anonymousx.presentation.di

import com.example.anonymousx.presentation.add_user.AddUserViewModel
import com.example.anonymousx.presentation.chatScreen.ChatViewModel
import com.example.anonymousx.presentation.groupChat.GroupsScreenViewModel
import com.example.anonymousx.presentation.usersScreen.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val presentationModule = module{
    viewModel{
        AddUserViewModel()
    }




    viewModel{UserViewModel()}

    viewModel{ ChatViewModel() }

    viewModel { GroupsScreenViewModel() }
}