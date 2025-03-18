package com.example.alcocalendar.features.session_manage.media.presentation

import com.example.alcocalendar.features.session_manage.media.domain.model.MediaItem
import java.time.LocalDate

data class MediaState(
    val date: LocalDate = LocalDate.now(),
    val mediaItems: List<MediaItem> = emptyList(),
    val isExpanded: Boolean = false,
    val isInSelectionMode: Boolean = false,
    val selectedMedia: List<MediaItem> = emptyList()
)
