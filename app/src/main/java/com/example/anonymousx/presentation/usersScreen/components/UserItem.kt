package com.example.anonymousx.presentation.usersScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.anonymousx.domain.model.Users


@Composable
fun UserItem(users: Users, onClick:()->Unit)
{







    Row(modifier= Modifier
        .padding(vertical = 9.dp)
        .fillMaxWidth()
        .height(60.dp)
        .clickable { onClick() })
    {
            Box(modifier= Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.Blue), contentAlignment = Alignment.Center) {

                Text(text = users.username.first().toString(), color = Color.White,
                    fontSize = 32.sp, fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.width(20.dp))
            Text(modifier = Modifier.align(Alignment.CenterVertically),text =users.username,
                maxLines = 1, overflow = TextOverflow.Ellipsis,

                style = TextStyle(color = Color.White, fontSize = 22.sp)
            )
    }
}