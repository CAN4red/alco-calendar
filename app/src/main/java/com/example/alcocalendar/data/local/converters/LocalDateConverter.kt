package com.example.alcocalendar.data.local.converters

import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

class LocalDateConverter {

    @TypeConverter
    fun fromLocalDate(localDate: LocalDate): String {
        val formatter = DateTimeFormatter.ofPattern("d.M.yyyy", Locale.ENGLISH)
        return localDate.format(formatter)
    }

    @TypeConverter
    fun toLocalDate(string: String): LocalDate {
        val (day, monthValue, year) = string.split(".").map { it.toInt() }
        return LocalDate.of(year, monthValue, day)
    }
}