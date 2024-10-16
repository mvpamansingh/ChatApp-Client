package com.example.anonymousx.presentation.groupConversation




import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.anonymousx.R
import com.example.anonymousx.domain.model.SentGroupMessage
import com.example.anonymousx.presentation.usersScreen.components.UserAppBar

@Composable
fun GroupConversationScreenn(
    navController: NavController,
    groupId: String,
    senderId: String,
    viewModel: GroupConversationViewModel
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = groupId) {
        viewModel.getGroupMessages(groupId)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .background(color = colorResource(id = R.color.teal_700))
    ) {
        UserAppBar("Group Chat")

        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            reverseLayout = false
        ) {
            items(state.conversationList) { message ->
                GroupMessageBox(
                    message = message,
                    isCurrentUser = message.senderId == senderId
                )
            }
        }

        GroupMessageInputField { message ->
            val sendm = SentGroupMessage(
                groupChatId = groupId,
                senderId = senderId,
                message = message
            )
            viewModel.sendGroupMessage(sendm)
        }
    }
}