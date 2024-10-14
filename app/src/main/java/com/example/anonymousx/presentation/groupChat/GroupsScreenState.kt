package com.example.anonymousx.presentation.groupChat

import com.example.anonymousx.domain.model.IndividualGroup

data class GroupsScreenState(
    val groupsList:List<IndividualGroup> = emptyList()
)