package com.example.anonymousx.presentation.chatScreen

import androidx.collection.floatObjectMapOf
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import java.time.format.TextStyle


@Composable
fun MessageBox(
    message: Message,

)
{
val modifier= if(message.receiverId==message.senderId)
{
    //
    //

    Modifier
        .padding(start = 16.dp, end = 8.dp)
        .defaultMinSize(minHeight = 60.dp)
        .clip(RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp, bottomStart = 20.dp))
        .background(
            brush = Brush.linearGradient(
                colors = listOf(
                    Color(0xFF007EF4),
                    Color(0xFFE7DB72),
                )
            )
        )
}
    else{
    Modifier
        .padding(start = 8.dp, end = 16.dp)
        .defaultMinSize(minHeight = 60.dp)
        .clip(RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp, bottomStart = 20.dp))
        .background(
            brush = Brush.linearGradient(
                colors = listOf(
                    Color(0xFF007EF4),
                    Color(0xFFE7DB72),
                )
            )
        )
    }

    val boxArrangement = if(message.receiverId ==message.senderId) Alignment.CenterEnd else Alignment.CenterStart

    Box(
        modifier= Modifier
            .padding(vertical = 12.dp)
            .fillMaxWidth(), contentAlignment = boxArrangement
    ){

        Row (verticalAlignment = Alignment.Bottom){
            Box (modifier=modifier){

                Column(modifier= Modifier.padding(8.dp),
                    horizontalAlignment =Alignment.Start){

                    Text(text = message.message,
                        style= androidx.compose.ui.text.TextStyle(
                            color = Color.White,
                            fontSize = 16.sp
                        ))
                    Spacer(modifier = Modifier.height(8.dp))


                    Text(text = message.timestamp,
                        style = androidx.compose.ui.text.TextStyle(
                                color = Color.White,
                            fontSize = 12.sp
                        ))
                }

            }

        }






    }
}