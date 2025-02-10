package com.example.alcocalendar.core.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "drinking_session")
data class DrinkingSession(
    @PrimaryKey(autoGenerate = false)
    val date: LocalDate,
)