package com.example.alcocalendar.core.data.local.converters

import androidx.room.TypeConverter
import java.time.Year

class YearTypeConverter {

    @TypeConverter
    fun fromYear(year: Year): String {
        return year.toString()
    }

    @TypeConverter
    fun toYear(string: String): Year {
        return Year.of(string.toInt())
    }
}