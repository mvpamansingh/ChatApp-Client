package com.example.anonymousx.presentation.chatScreen



data class Message(
    val message:String,
    val senderId:String,
    val receiverId:String,
    val timestamp:String? = null
)


val messageList= listOf(




    Message(
        message = "how are you",
        senderId= "adasds",
        timestamp = "21:22",
        receiverId = "fsdfs"
    ),

    Message(
        message = "everthing fine",
    senderId= "adasddfsfsss",
    timestamp = "21:22",
        receiverId = "adfsdfs"
),
    Message(
        message = "hello",
        senderId= "dfsdsss",
        timestamp = "1:54",
        receiverId = "dsdaa"
    ),

)