package com.example.anonymousx.presentation.chatScreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.anonymousx.R


@Composable
fun MessageInputField(

    onSend:(String)->Unit
) {

    val message = remember {
        mutableStateOf("")
    }

    val containerColor = Color(0xFF2B2B2B)

    TextField(
        value = message.value, onValueChange = {
            message.value = it
        },

        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 9.dp)
            .navigationBarsPadding()
            .imePadding(),
        textStyle = TextStyle(
            color = Color(0xFFCCCCCC),
            fontSize = 16.sp,
            //fontFamily = FontFamily(Font(R.font.sen))
        ),
        placeholder = {
            Text(
                text = "Type a message...",
                style = TextStyle(
                    color = Color(0xFFCCCCCC),
                    fontSize = 16.sp,// fontFamily =
                )
            )
        },
        trailingIcon = {
            IconButton(
                onClick = {
                    onSend(message.value)
                    message.value = ""
                },
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color(0xFFCCCCCC)
                )
            ) {

                Icon(imageVector = Icons.AutoMirrored.Outlined.Send, contentDescription = null)

            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        shape = RoundedCornerShape(50),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = containerColor,
            unfocusedContainerColor = containerColor,
            disabledContainerColor = containerColor,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )


}