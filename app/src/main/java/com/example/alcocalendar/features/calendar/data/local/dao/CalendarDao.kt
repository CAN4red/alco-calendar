package com.example.alcocalendar.features.calendar.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.alcocalendar.core.data.local.relations.DrinkingSessionWithDrinkIntakes
import java.time.Year
import java.time.YearMonth

@Dao
interface CalendarDao {

    @Transaction
    @Query("SELECT * FROM drinking_session WHERE yearMonth = :yearMonth")
    fun getDrinkingSessionsWithDrinkIntakesByMonth(yearMonth: YearMonth): List<DrinkingSessionWithDrinkIntakes>

    @Transaction
    @Query("SELECT * FROM drinking_session WHERE year = :year")
    fun getDrinkingSessionsWithDrinkIntakesByYear(year: Year): List<DrinkingSessionWithDrinkIntakes>
}