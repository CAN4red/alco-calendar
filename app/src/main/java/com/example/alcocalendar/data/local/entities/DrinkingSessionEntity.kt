package com.example.alcocalendar.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "drinking_session")
data class DrinkingSessionEntity(
    @PrimaryKey(autoGenerate = false)
    val date: LocalDate,
)