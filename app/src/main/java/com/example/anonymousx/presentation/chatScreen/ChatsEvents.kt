package com.example.anonymousx.presentation.chatScreen




sealed class ChatsEvents {

    data class SendMessage(val message: Message):ChatsEvents()
}