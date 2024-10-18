package com.example.anonymousx

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.anonymousx.presentation.navigation.SetUpnavGraph
import com.example.anonymousx.presentation.settingScreen.AboutScreen
import com.example.anonymousx.presentation.settingScreen.ContactScreen
import com.example.anonymousx.ui.theme.AnonymousXTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
        )
        installSplashScreen()
        setContent {
            AnonymousXTheme {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(color = colorResource(id = R.color.white)))
                {
                    SetUpnavGraph()
                   // AboutScreen()
                 //   ContactScreen()
                }

            }
        }
    }
}

