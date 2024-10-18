
package com.example.anonymousx.presentation.groupConversation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anonymousx.domain.model.ReceivedGroupMessage
import com.example.anonymousx.domain.model.SentGroupMessage
import com.example.anonymousx.domain.repository.ChatsRepository
import com.google.gson.Gson
import io.socket.client.IO
import io.socket.client.Socket
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GroupConversationViewModel(

) : ViewModel(),KoinComponent {

    private val chatsRepository: ChatsRepository by inject()
    private val gson = Gson()
    private lateinit var socket: Socket
    private lateinit var currentGroupId: String


    private val _state = MutableStateFlow(GroupConversationState())
    val state = _state.asStateFlow()

    init {
        setupSocket()
    }

    private fun setupSocket() {
        socket = IO.socket("http://192.168.1.3:3000/") // Replace with your server URL
        socket.connect()

        socket.on("newGroupMessage") { args ->
            args[0]?.let { data ->
                val messageJson = data.toString()
                val message = gson.fromJson(messageJson, ReceivedGroupMessage::class.java)
                addMessageToState(message)
            }
        }
    }

    fun joinGroup(groupId: String) {
        currentGroupId = groupId
        socket.emit("joinGroup", groupId)
    }

    fun leaveGroup() {
        socket.emit("leaveGroup", currentGroupId)
    }


    fun getGroupMessages(groupId: String) {
        viewModelScope.launch {
            chatsRepository.getGroupMessage(groupId).collect { messages ->
                _state.update { it.copy(conversationList = messages) }
            }
        }
    }

    fun sendGroupMessage(sentGroupMessage: SentGroupMessage) {

        viewModelScope.launch {
            chatsRepository.sendGroupMessage(sentGroupMessage)
        }
    }

    private fun addMessageToState(message: ReceivedGroupMessage) {
        _state.update { currentState ->
            val updatedList = currentState.conversationList.toMutableList()
            updatedList.add(message)
            currentState.copy(conversationList = updatedList)
        }
    }

    override fun onCleared() {
        super.onCleared()
        leaveGroup()
        socket.disconnect()
    }

}