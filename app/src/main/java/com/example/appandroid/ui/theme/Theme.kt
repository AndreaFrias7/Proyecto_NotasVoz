package com.example.appandroid.ui.theme
import androidx.compose.ui.graphics.Color

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Red80,
    secondary = Blue80,
    background = Black80,
    surface = PurpleBlue80,
    onPrimary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White
)


private val LightColorScheme = lightColorScheme(
    primary = Red80,            // Botón de grabar, acentos
    secondary = PurpleBlue80,   // Decorativos o elementos secundarios
    background = Blue80,        // Fondo general
    surface = Color.White,      // Tarjetas o superficies
    onPrimary = Color.White,    // Texto sobre botones rojos
    onBackground = Black80,     // Texto principal
    onSurface = Black80         // Texto sobre superficies blancas
)


@Composable
fun AppAndroidTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}