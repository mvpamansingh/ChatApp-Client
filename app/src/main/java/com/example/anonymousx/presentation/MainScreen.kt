
package com.example.anonymousx.presentation.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.anonymousx.R
import com.example.anonymousx.presentation.groupChat.GroupsScreen
import com.example.anonymousx.presentation.groupChat.GroupsScreenViewModel
import com.example.anonymousx.presentation.navigation.ChatScreen
import com.example.anonymousx.presentation.navigation.GroupConversationScreen
import com.example.anonymousx.presentation.navigation.GroupsTab
import com.example.anonymousx.presentation.navigation.SettingsTab
import com.example.anonymousx.presentation.navigation.UsersTab
import com.example.anonymousx.presentation.usersScreen.UserViewModel
import com.example.anonymousx.presentation.usersScreen.UsersScreen

@Composable
fun MainScreen(
    mainNavController: NavHostController,
    userViewModel: UserViewModel,
    groupsViewModel: GroupsScreenViewModel
) {
    val bottomNavController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigation(navController = bottomNavController) }
    ) { innerPadding ->
        NavHost(
            navController = bottomNavController,
            startDestination = UsersTab,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<UsersTab> {
                val state by userViewModel.state.collectAsStateWithLifecycle()
                UsersScreen(
                    state = state,
                    event = userViewModel::onEvent
                ) { receiverId ->
                    mainNavController.navigate(
                        ChatScreen(
                        receiverId = receiverId,
                        senderId = "66f6251740d285204dee80f7"
                    )
                    )
                }
            }
            composable<GroupsTab> {
                val state by groupsViewModel.state.collectAsStateWithLifecycle()
                GroupsScreen(
                    state = state,
                    event = groupsViewModel::onEvent
                ) { groupId ->
                    mainNavController.navigate(
                        GroupConversationScreen(
                            groupId = groupId,
                            senderId = "66f6251740d285204dee80f7" // Hardcoded senderId
                        )
                    )
                }
            }
            composable<SettingsTab> {
                // TODO: Implement SettingsScreen
                Text("Settings Screen")
            }
        }
    }
}

@Composable
fun BottomNavigation(navController: NavHostController) {
    val items = listOf(
        Triple(UsersTab, "Users", R.drawable.baseline_connect_without_contact_24),
        Triple(GroupsTab, "Groups", R.drawable.baseline_groups_24),
        Triple(SettingsTab, "Settings", R.drawable.baseline_settings_24)
    )
    
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        items.forEach { (route, title, iconResId) ->
            NavigationBarItem(
                icon = { Icon(painterResource(id = iconResId), contentDescription = title) },
                label = { Text(title) },
                selected = currentRoute == route,
                onClick = {
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}