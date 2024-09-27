package com.example.anonymousx.presentation.add_user

sealed class AddUserEvent {

    data class AddUser(val userName:String):AddUserEvent()
}