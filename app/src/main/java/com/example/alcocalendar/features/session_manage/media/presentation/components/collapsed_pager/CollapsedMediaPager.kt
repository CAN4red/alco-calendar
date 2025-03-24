package com.example.alcocalendar.features.session_manage.media.presentation.components.collapsed_pager

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import com.example.alcocalendar.features.session_manage.media.presentation.MediaEvent
import com.example.alcocalendar.features.session_manage.media.presentation.MediaState
import com.example.alcocalendar.features.session_manage.media.presentation.components.MediaPager

@Composable
fun CollapsedMediaPager(
    state: MediaState,
    onEvent: (MediaEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = Modifier
        .aspectRatio(1f)
        .clickable { onEvent(MediaEvent.ExpandMedia) }
    ) {
        MediaPager(
            state = state,
            onEvent = onEvent,
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxWidth(),
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background.copy(alpha = 0.32f))
                .zIndex(1f)
        )
    }
}

@Preview
@Composable
private fun CollapsedMediaPagerPreview() {
    CollapsedMediaPager(
        state = MediaState(),
        onEvent = { },
    )
}