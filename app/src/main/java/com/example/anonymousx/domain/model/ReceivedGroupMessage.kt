package com.example.anonymousx.domain.model

import com.example.anonymousx.presentation.chatScreen.Message

data class ReceivedGroupMessage(

    val message:String,
    val senderName:String,
    val senderId:String,
    val timestamp:String
)
fun ReceivedGroupMessage.toMessage(): Message {
    return Message(
        message = this.message,
        senderId = this.senderId,
        receiverId = "", // Group messages don't have a specific receiver
        timestamp = this.timestamp
    )
}