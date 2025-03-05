package com.example.alcocalendar.features.drink_intake.presentation.utils

import java.text.NumberFormat
import java.util.Locale

object Formatter {

    fun Double.formatAsString(): String {
        return NumberFormat.getInstance(Locale.getDefault()).apply {
            maximumFractionDigits = 3
            isGroupingUsed = false
        }.format(this)
    }
}