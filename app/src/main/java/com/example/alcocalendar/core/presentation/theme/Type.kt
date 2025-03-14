package com.example.alcocalendar.core.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.alcocalendar.R

val ReadexPro = FontFamily(
    Font(R.font.readex_pro_light, FontWeight.Light),
    Font(R.font.readex_pro, FontWeight.Normal),
    Font(R.font.readex_pro_medium, FontWeight.Medium),
    Font(R.font.readex_pro_semibold, FontWeight.SemiBold),
    Font(R.font.readex_pro_bold, FontWeight.Bold),
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = ReadexPro,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp
    ),

    displayMedium = TextStyle(
        fontFamily = ReadexPro,
        fontWeight = FontWeight.Bold,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp,
    ),

    displaySmall = TextStyle(
        fontFamily = ReadexPro,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp
    ),

    headlineMedium = TextStyle(
        fontFamily = ReadexPro,
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp,
    ),

    titleMedium = TextStyle(
        fontFamily = ReadexPro,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp,
    ),

    bodyLarge = TextStyle(
        fontFamily = ReadexPro,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.25.sp,
    ),

    bodyMedium = TextStyle(
        fontFamily = ReadexPro,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp,
    ),

    bodySmall = TextStyle(
        fontFamily = ReadexPro,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp,
    ),

    labelLarge = TextStyle(
        fontFamily = ReadexPro,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.5.sp,
    ),

    labelMedium = TextStyle(
        fontFamily = ReadexPro,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
    ),
)
