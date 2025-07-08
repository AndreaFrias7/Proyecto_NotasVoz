package com.example.appandroid.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Navy,
    secondary = Blue80,
    background = Black80,
    surface = White80,
    onPrimary = Blue40,
    onBackground = Blue40,
    onSurface = Blue40
)

private val LightColorScheme = lightColorScheme(
    primary = Navy,         // Botones y acentos
    secondary = White80,    // Elementos secundarios
    background = White80,   // Fondo principal
    surface = Blue40,       // Superficies blancas
    onPrimary = Blue40,     // Texto sobre botones
    onBackground = Black80, // Texto normal
    onSurface = Black80     // Texto sobre superficies blancas
)

@Composable
fun AppAndroidTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
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
