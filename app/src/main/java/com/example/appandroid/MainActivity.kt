package com.example.appandroid

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appandroid.ui.screens.HomeScreen
import com.example.appandroid.ui.screens.NotesScreen
import com.example.appandroid.ui.screens.VoiceNoteScreen
import com.example.appandroid.ui.theme.AppAndroidTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppAndroidTheme(darkTheme = false) {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier,
                    containerColor = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") { HomeScreen(navController) }
                        composable("notes") { NotesScreen(navController) }
                        composable("voice_note") { VoiceNoteScreen(navController) }
                    }
                }
            }
        }
    }
}
