package com.example.alcocalendar.features.session_manage.media.domain.model

import java.time.LocalDate

data class MediaItem(
    val date: LocalDate,
    val name: String,
    val path: String? = null,
    val type: MediaType,
    val timeStamp: Long? = null,
)