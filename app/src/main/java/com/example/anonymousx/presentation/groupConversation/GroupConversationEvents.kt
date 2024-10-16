package com.example.anonymousx.presentation.groupConversation

import com.example.anonymousx.domain.model.SentGroupMessage
import com.example.anonymousx.presentation.chatScreen.Message

sealed class GroupConversationEvents {

    data class SendMessage(val sentGroupMessage: SentGroupMessage): GroupConversationEvents()
    data class FetchGroupMessages(val groupId: String) : GroupConversationEvents()

}