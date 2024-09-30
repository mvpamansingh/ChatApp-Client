package com.example.anonymousx.presentation.chatScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anonymousx.domain.repository.ChatsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ChatViewModel:ViewModel(), KoinComponent {

private val chatsRepository :ChatsRepository by inject()



private val _state= MutableStateFlow(ChatStates())
    val state =_state


    fun onEvent(events: ChatsEvents)
    {
        when(events)
        {
            is ChatsEvents.SendMessage ->
            {
                viewModelScope.launch {

                    chatsRepository.sendMessage(events.message)

                }
            }
        }
    }

    fun getMessages(chatRoomId:String)
    {
        viewModelScope.launch {
            chatsRepository.getMessages(chatRoomId).collect{

                _state.value= state.value.copy(messageist = it)
            }
        }

    }

}