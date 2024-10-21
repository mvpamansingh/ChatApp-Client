package com.example.anonymousx.data.prefrences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.anonymousx.domain.model.ReceivedUserInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferences(private val context: Context) {

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_preferences")
        private val USER_ID_KEY = stringPreferencesKey("user_id")
        private val JWT_KEY = stringPreferencesKey("jwt")
        private val USERNAME_KEY = stringPreferencesKey("username")
    }

    suspend fun saveUserInfo(userInfo: ReceivedUserInfo) {
        context.dataStore.edit { preferences ->
            preferences[USER_ID_KEY] = userInfo.id ?: ""
            preferences[JWT_KEY] = userInfo.jwt
            preferences[USERNAME_KEY] = userInfo.username
        }
    }

    fun getUserInfo(): Flow<ReceivedUserInfo> = context.dataStore.data.map { preferences ->
        ReceivedUserInfo(
            id = preferences[USER_ID_KEY],
            jwt = preferences[JWT_KEY] ?: "",
            username = preferences[USERNAME_KEY] ?: ""
        )
    }

    suspend fun clearUserInfo() {
        context.dataStore.edit { preferences ->
            preferences.clear()
        }
    }
}