package com.example.appandroid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.foundation.background

import androidx.compose.ui.unit.dp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appandroid.ui.theme.AppAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Andrea",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        color = MaterialTheme.colorScheme.onBackground,
        style = MaterialTheme.typography.headlineLarge,
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    )
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppAndroidTheme {
        Greeting("Andrea")
    }
}