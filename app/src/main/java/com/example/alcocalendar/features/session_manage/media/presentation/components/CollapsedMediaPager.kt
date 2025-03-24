package com.example.alcocalendar.features.session_manage.media.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.example.alcocalendar.features.session_manage.media.presentation.MediaEvent
import com.example.alcocalendar.features.session_manage.media.presentation.MediaState

@Composable
fun CollapsedMediaPager(
    state: MediaState,
    onEvent: (MediaEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    MediaPager(
        state = state,
        onEvent = onEvent,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .fillMaxWidth()
            .clickable { onEvent(MediaEvent.ExpandMedia) },
        imageModifier = Modifier.aspectRatio(1f)
    )
}