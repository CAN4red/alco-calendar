package com.example.alcocalendar.core.domain.model

import java.time.LocalDate
import java.time.Year
import java.time.YearMonth

data class DrinkingSession(
    val date: LocalDate,
    val yearMonth: YearMonth = YearMonth.of(date.year, date.month),
    val year: Year = Year.of(date.year),
)
