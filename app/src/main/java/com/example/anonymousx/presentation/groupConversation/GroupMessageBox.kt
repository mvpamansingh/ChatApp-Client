package com.example.anonymousx.presentation.groupConversation






import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.anonymousx.domain.model.ReceivedGroupMessage
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@Composable
fun GroupMessageBox(
    message: ReceivedGroupMessage,
    isCurrentUser: Boolean
) {
    val alignment = if (isCurrentUser) Alignment.CenterEnd else Alignment.CenterStart
    val backgroundColor = if (isCurrentUser) {
        Brush.linearGradient(listOf(Color(0xFF007EF4), Color(0xFFE7DB72)))
    } else {
        Brush.linearGradient(listOf(Color(0xFF4CAF50), Color(0xFF8BC34A)))
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        contentAlignment = alignment
    ) {
        Column(
            modifier = Modifier
                .widthIn(max = 300.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(backgroundColor)
                .padding(8.dp)
        ) {
            Text(
                text = message.senderName,
                color = Color.White,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = message.message,
                color = Color.White,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = formatTimestamp(message.timestamp),
                color = Color.White,
                fontSize = 10.sp
            )
        }
    }
}

fun formatTimestamp(timestamp: String): String {
    val formatter = DateTimeFormatter.ISO_DATE_TIME
    val zonedDateTime = ZonedDateTime.parse(timestamp, formatter)
    val zoneId = ZoneId.of("Asia/Kolkata")
    val istDateTime = zonedDateTime.withZoneSameInstant(zoneId)
    return istDateTime.format(DateTimeFormatter.ofPattern("HH:mm"))
}