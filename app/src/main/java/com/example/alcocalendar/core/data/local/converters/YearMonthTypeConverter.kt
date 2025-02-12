package com.example.alcocalendar.core.data.local.converters

import androidx.room.TypeConverter
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.util.Locale

class YearMonthTypeConverter {

    @TypeConverter
    fun fromYearMonth(yearMonth: YearMonth): String {
        val formatter = DateTimeFormatter.ofPattern("M.yyyy", Locale.ENGLISH)
        return yearMonth.format(formatter)
    }

    @TypeConverter
    fun toYearMonth(string: String): YearMonth {
        val (monthValue, year) = string.split(".").map { it.toInt() }
        return YearMonth.of(year, monthValue)
    }
}