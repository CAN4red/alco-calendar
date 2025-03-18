package com.example.alcocalendar.features.session_manage.media.presentation

import com.example.alcocalendar.features.session_manage.media.domain.model.MediaItem

sealed interface MediaEvent {
    data object ExpandMedia : MediaEvent
    data object CollapseMedia : MediaEvent
    data object EnterSelectionMode : MediaEvent
    data object ExitSelectionMode : MediaEvent
    data class SelectMedia(val mediaItem: MediaItem) : MediaEvent
    data class UnselectMedia(val mediaItem: MediaItem) : MediaEvent
    data class SaveMedia(val mediaItems: List<MediaItem>) : MediaEvent
    data class DeleteMedia(val mediaItem: MediaItem) : MediaEvent
}