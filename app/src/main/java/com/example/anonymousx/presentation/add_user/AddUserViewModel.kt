package com.example.anonymousx.presentation.add_user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anonymousx.domain.model.Users
import com.example.anonymousx.domain.repository.ChatsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AddUserViewModel: ViewModel() , KoinComponent{


    val chatRepository: ChatsRepository by  inject()

   private val _state = MutableStateFlow(AddUserState())
    val state = _state

    fun onEvent(event: AddUserEvent)
    {

        when(event)
        {
            is AddUserEvent.AddUser ->
            {
               val username =event.userName
                viewModelScope.launch {
                    addUser(username)
                }
            }
        }
    }

    private suspend fun addUser(username: String) {

        val users = Users(username = username)
        chatRepository.addUser(users).collect{status->

            if(status==201){
                _state.value = state.value.copy(addedUser = true)
            }
            else
            {
                _state.value = state.value.copy(addedUser = false)

            }
        }
    }
}