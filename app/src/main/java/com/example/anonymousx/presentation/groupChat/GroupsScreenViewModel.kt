package com.example.anonymousx.presentation.groupChat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import com.example.anonymousx.domain.repository.ChatsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject



class GroupsScreenViewModel(): ViewModel(),KoinComponent {

    private val chatsRepository:ChatsRepository by inject()



    private val _state = MutableStateFlow(GroupsScreenState())
    val state =_state

    fun onEvent(event: GroupsScreenEvent)
    {
        when(event)
        {
            GroupsScreenEvent.FetchGroupsList -> {

                viewModelScope.launch {

                    chatsRepository.getGroups().collect{groups->
                        _state.value=state.value.copy(
                            groupsList = groups
                        )
                    }
                }

            }
        }
    }

}