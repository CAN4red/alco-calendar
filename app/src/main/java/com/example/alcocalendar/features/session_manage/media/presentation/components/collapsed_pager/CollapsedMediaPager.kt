package com.example.alcocalendar.features.session_manage.media.presentation.components.collapsed_pager

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.alcocalendar.features.session_manage.media.presentation.MediaEvent
import com.example.alcocalendar.features.session_manage.media.presentation.MediaState
import com.example.alcocalendar.features.session_manage.media.presentation.MediaUtils.getDefaultMediaItem
import com.example.alcocalendar.features.session_manage.media.presentation.components.MediaPager
import com.example.alcocalendar.features.session_manage.media.presentation.components.PageIndicator

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun CollapsedMediaPager(
    state: MediaState,
    onEvent: (MediaEvent) -> Unit,
    animatedVisibilityScope: AnimatedVisibilityScope,
    sharedTransitionScope: SharedTransitionScope,
    modifier: Modifier = Modifier
) {
    val mediaItems = state.mediaItems.ifEmpty { listOf(getDefaultMediaItem(state)) }
    val pagerState = rememberPagerState(
        initialPage = state.selectedPage,
        pageCount = { mediaItems.size }
    )

    Box(
        modifier = modifier
            .aspectRatio(1f)
            .clickable { onEvent(MediaEvent.ExpandMedia) }
    ) {
        with(sharedTransitionScope) {
            MediaPager(
                mediaItems = mediaItems,
                pagerState = pagerState,
                onEvent = onEvent,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .sharedElement(
                        rememberSharedContentState(key = "media_pager"),
                        animatedVisibilityScope = animatedVisibilityScope
                    )
                    .fillMaxWidth(),
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.2f))
                .zIndex(1f)
        )

        PageIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .zIndex(2f)
        )
    }
}
