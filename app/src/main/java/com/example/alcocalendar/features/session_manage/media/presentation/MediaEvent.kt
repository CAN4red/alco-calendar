package com.example.alcocalendar.features.session_manage.media.presentation

import android.net.Uri
import com.example.alcocalendar.features.session_manage.media.domain.model.MediaItem

sealed interface MediaEvent {
    data object ExpandMedia : MediaEvent
    data object CollapseMedia : MediaEvent
    data object EnterSelectionMode : MediaEvent
    data object ExitSelectionMode : MediaEvent
    data class SaveMedia(val uris: List<Uri>) : MediaEvent
    data class DeleteMedia(val mediaItem: MediaItem?) : MediaEvent
    data class ScrollToPage(val pageNo: Int) : MediaEvent
}