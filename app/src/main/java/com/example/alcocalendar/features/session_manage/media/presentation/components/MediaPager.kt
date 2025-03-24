package com.example.alcocalendar.features.session_manage.media.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.features.session_manage.media.presentation.MediaEvent
import com.example.alcocalendar.features.session_manage.media.presentation.MediaState
import com.example.alcocalendar.features.session_manage.media.presentation.MediaUtils.getDefaultMediaItem

@Composable
fun MediaPager(
    state: MediaState,
    onEvent: (MediaEvent) -> Unit,
    contentScale: ContentScale,
    modifier: Modifier = Modifier,
    hasBackground: Boolean = false
) {
    val mediaItems = state.mediaItems.ifEmpty { listOf(getDefaultMediaItem(state)) }
    val pagerState = rememberPagerState(initialPage = state.selectedPage) { mediaItems.size }

    LaunchedEffect(pagerState.currentPage) {
        onEvent(MediaEvent.ScrollToPage(pagerState.currentPage))
    }

    HorizontalPager(
        state = pagerState,
        modifier = modifier
    ) { mediaIndex ->
        ImageItem(
            mediaItem = mediaItems[mediaIndex],
            contentScale = contentScale,
            hasBackground = hasBackground,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
private fun MediaPagerPreview() {
    MediaPager(
        state = MediaState(),
        contentScale = ContentScale.Fit,
        onEvent = {},
    )
}