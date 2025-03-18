package com.example.alcocalendar.features.session_manage.media.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.features.session_manage.media.presentation.MediaEvent
import com.example.alcocalendar.features.session_manage.media.presentation.MediaState
import com.example.alcocalendar.features.session_manage.media.presentation.MediaUtils.getDefaultMediaItem

@Composable
fun MediaPager(
    state: MediaState,
    onEvent: (MediaEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState { state.mediaItems.size.takeIf { it != 0 } ?: 1 }
    val mediaItems = state.mediaItems.ifEmpty { listOf(getDefaultMediaItem(state)) }

    HorizontalPager(
        state = pagerState,
        modifier = modifier.clickable {
            onEvent(MediaEvent.ExpandMedia)
        }
    ) { mediaIndex ->
        ImagePagerItem(
            mediaItem = mediaItems[mediaIndex],
        )
    }
}

@Preview
@Composable
private fun MediaPagerPreview() {
    MediaPager(
        state = MediaState(),
        onEvent = {},
    )
}