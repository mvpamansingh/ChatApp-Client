package com.example.anonymousx.presentation.chatScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anonymousx.domain.repository.ChatsRepository
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ChatViewModel:ViewModel(), KoinComponent {

private val chatsRepository :ChatsRepository by inject()






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



}