package com.example.alcocalendar.features.session_manage.notes.domain.model

import java.time.LocalDate

data class Note(
    val date: LocalDate = LocalDate.now(),
    val content: String = "",
)
