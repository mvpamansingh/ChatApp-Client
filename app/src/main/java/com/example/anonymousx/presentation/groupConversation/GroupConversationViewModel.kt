
package com.example.anonymousx.presentation.groupConversation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anonymousx.domain.model.SentGroupMessage
import com.example.anonymousx.domain.repository.ChatsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GroupConversationViewModel(

) : ViewModel(),KoinComponent {

    private val chatsRepository: ChatsRepository by inject()

//
//    fun onEvent(event: GroupConversationEvents) {
//        when (event) {
//            is GroupConversationEvents.FetchGroupMessages -> fetchGroupMessages(event.groupId)
//            // TODO: Add more events as needed
//            is GroupConversationEvents.SendMessage -> TODO()
//        }
//    }


private val _state = MutableStateFlow(GroupConversationState())
    val state = _state.asStateFlow()

    fun getGroupMessages(groupId: String) {
        viewModelScope.launch {
            chatsRepository.getGroupMessage(groupId).collect { messages ->
                _state.update { it.copy(conversationList = messages) }
            }
        }
    }

    fun sendGroupMessage(sentGroupMessage: SentGroupMessage) {
        // Implement sending group message logic here
        // You might need to add a new method to your ChatsRepository
        viewModelScope.launch {
            chatsRepository.sendGroupMessage(sentGroupMessage)
        }

    }
}