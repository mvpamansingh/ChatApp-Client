@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.anonymousx.presentation.usersScreen.components

import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.anonymousx.R


@Composable
fun UserAppBar()
{





    TopAppBar(title = {
        Text(text = "Users",
            style= TextStyle(
                color = Color.White,
                fontSize = 25.sp
            )
        )

    },

        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Blue
        )
//        , navigationIcon = {
//            IconButton(onClick = { /*TODO*/ }) {
//                Icon(painter = painterResource(id = R.drawable.baseline_mode_edit_outline_24), contentDescription ="" ,
//                    tint= Color(0xFFCCCCCC))
//            }
//        }



    )

}