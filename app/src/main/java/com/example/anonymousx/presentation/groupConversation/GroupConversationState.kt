package com.example.anonymousx.presentation.groupConversation

import com.example.anonymousx.domain.model.ReceivedGroupMessage


data class GroupConversationState(
    val conversationList:List<ReceivedGroupMessage> = emptyList()
)