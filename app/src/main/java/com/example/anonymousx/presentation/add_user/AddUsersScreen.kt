package com.example.anonymousx.presentation.add_user

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun AddUsersScreen(
    modifier: Modifier= Modifier,

)
{



    Column(

        modifier= Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment= Alignment.CenterHorizontally
    ) {
        val textState= remember {
            mutableStateOf("")
        }

        OutlinedTextField(value = textState.value, onValueChange = {textState.value= it},
            label = { Text(text = "Enter Name")},
            placeholder = { Text(text = " Enter your name here..")},
            modifier= Modifier
                .fillMaxWidth()
                .padding(16.dp),
            singleLine = true
        
        )
        
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Add User")
        }
        
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Let's go")
        }

    }
}