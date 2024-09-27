package com.example.anonymousx.presentation.usersScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anonymousx.domain.repository.ChatsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class UserViewModel():ViewModel(), KoinComponent
{
    private val chatsRepository:ChatsRepository by inject()




    private val _state = MutableStateFlow(UsersState())
    val state = _state

    fun onEvent(event: UserEvent)
    {
        when(event)
        {
            UserEvent.FetchUserList -> {

               viewModelScope.launch {
                   chatsRepository.fetchUsers().collect{userList->

                       _state.value= state.value.copy(
                           usersList = userList
                       )
                   }
               }
            }
        }
    }
}