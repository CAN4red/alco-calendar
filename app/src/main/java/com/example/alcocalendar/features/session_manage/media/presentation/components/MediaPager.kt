package com.example.alcocalendar.features.session_manage.media.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.features.session_manage.media.domain.model.MediaItem
import com.example.alcocalendar.features.session_manage.media.domain.model.MediaType
import com.example.alcocalendar.features.session_manage.media.presentation.MediaEvent
import java.time.LocalDate

@Composable
fun MediaPager(
    mediaItems: List<MediaItem>,
    onEvent: (MediaEvent) -> Unit,
    pagerState: PagerState,
    contentScale: ContentScale,
    modifier: Modifier = Modifier,
    hasBackground: Boolean = false
) {
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
        mediaItems = listOf(
            MediaItem(
                date = LocalDate.now(),
                name = "lol",
                type = MediaType.IMAGE,
            )
        ),
        pagerState = rememberPagerState { 1 },
        contentScale = ContentScale.Fit,
        onEvent = {},
    )
}