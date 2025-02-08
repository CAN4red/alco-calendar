package com.example.alcocalendar.data.local.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "drinking_sessions")
data class DrinkingSessionEntity(
    @PrimaryKey(autoGenerate = false)
    val date: LocalDate,
    @Embedded
    val totalIntake: TotalIntake,
)