package com.example.anonymousx.presentation.chatScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anonymousx.SocketHandler
import com.example.anonymousx.domain.repository.ChatsRepository
import com.google.gson.Gson
import io.socket.client.IO
import io.socket.client.Socket
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ChatViewModel:ViewModel(), KoinComponent {

private val chatsRepository :ChatsRepository by inject()

    private var socket : Socket = IO.socket("http://192.168.1.5:3000/")

    init {
        socket.connect()

        socket.on("newMessage"){

            it?.let {MessageData->


                val messageJson = MessageData[0]
                val message=  Gson().fromJson(messageJson.toString(),Message::class.java)

                val newMessageList = state.value.messageist.toMutableList()
                newMessageList.add(message)
                _state.value = state.value.copy(messageist = newMessageList)
            }
        }
    }

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

    override fun onCleared() {
        super.onCleared()
        socket.disconnect()
        socket.off()
    }

}