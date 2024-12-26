package com.example.alcocalendar.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.alcocalendar.ui.theme.color.DarkBackground
import com.example.alcocalendar.ui.theme.color.DarkPrimary
import com.example.alcocalendar.ui.theme.color.DarkSecondary
import com.example.alcocalendar.ui.theme.color.DarkSurface
import com.example.alcocalendar.ui.theme.color.LightBackground
import com.example.alcocalendar.ui.theme.color.LightPrimary
import com.example.alcocalendar.ui.theme.color.LightSecondary
import com.example.alcocalendar.ui.theme.color.LightSurface


private val DarkColorScheme = darkColorScheme(
    primary = DarkPrimary,
    secondary = DarkSecondary,

    background = DarkBackground,
    surface = DarkSurface,

    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color(0xFFE2E2E2),
    onSurface = Color.White,
)

private val LightColorScheme = lightColorScheme(
    primary = LightPrimary,
    secondary = LightSecondary,

    background = LightBackground,
    surface = LightSurface,

    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
)

@Composable
fun AlcoCalendarTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AlcoTypography,
        content = content
    )
}