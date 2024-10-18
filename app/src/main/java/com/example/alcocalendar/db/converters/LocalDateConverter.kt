package com.example.alcocalendar.db.converters

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

class LocalDateConverter {

    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun fromLocalDate(localDate: LocalDate): String {
        val formatter = DateTimeFormatter.ofPattern("d.M.yyyy", Locale.ENGLISH)
        return localDate.format(formatter)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun toLocalDate(string: String): LocalDate {
        val (day, monthValue, year) = string.split(".").map { it.toInt() }
        return LocalDate.of(year, monthValue, day)
    }
}