package com.example.alcocalendar.features.drink_intake.presentation.utils

import android.content.Context
import android.text.format.DateUtils
import java.text.NumberFormat
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date
import java.util.Locale

object Formatter {

    fun LocalDate.formatDayMonth(context: Context): String {
        val dateAdapter = Date.from(this.atStartOfDay(ZoneId.systemDefault()).toInstant())
        val formattedDate = DateUtils.formatDateTime(context, dateAdapter.time, DateUtils.FORMAT_NO_YEAR)
        return formattedDate
    }


    fun Double.formatAsString(): String {
        return NumberFormat.getInstance(Locale.getDefault()).apply {
            maximumFractionDigits = 3
            isGroupingUsed = false
        }.format(this)
    }
}