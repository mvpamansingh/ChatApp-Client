package com.example.anonymousx.presentation.groupChat

import com.example.anonymousx.domain.model.IndividualGroup
import com.example.anonymousx.presentation.usersScreen.UserEvent

sealed class GroupsScreenEvent {


    data object FetchGroupsList: GroupsScreenEvent()

    data class CreateNewGroup(val individualGroup: IndividualGroup):GroupsScreenEvent()
}