package com.example.alcocalendar.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.alcocalendar.ui.theme.color.GrayDark
import com.example.alcocalendar.ui.theme.color.Green
import com.example.alcocalendar.ui.theme.color.Purple
import com.example.alcocalendar.ui.theme.color.lightSurface


private val DarkColorScheme = darkColorScheme(

)

private val LightColorScheme = lightColorScheme(
    primary = Green,
    secondary = Purple,

    background = Color(0xFFFFFFFF),
    surface = lightSurface,

    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = GrayDark,
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