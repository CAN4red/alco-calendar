package com.example.alcocalendar.core.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.Year
import java.time.YearMonth

@Entity(tableName = "drinking_session")
data class DrinkingSessionEntity(
    @PrimaryKey(autoGenerate = false)
    val date: LocalDate,
    val yearMonth: YearMonth = YearMonth.of(date.year, date.month),
    val year: Year = Year.of(date.year),
)
