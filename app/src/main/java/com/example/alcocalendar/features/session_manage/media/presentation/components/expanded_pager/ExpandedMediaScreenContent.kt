package com.example.alcocalendar.features.session_manage.media.presentation.components.expanded_pager

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
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
import com.example.alcocalendar.features.session_manage.media.presentation.components.TopRowExpandedMedia

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ExpandedMediaScreenContent(
    state: MediaState,
    onEvent: (MediaEvent) -> Unit,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
    modifier: Modifier = Modifier
) {
    val mediaItems = state.mediaItems.ifEmpty { listOf(getDefaultMediaItem(state)) }
    val pagerState = rememberPagerState(
        initialPage = state.selectedPage,
        pageCount = { mediaItems.size }
    )

    Box(
        modifier = modifier
    ) {
        with(sharedTransitionScope) {
            MediaPager(
                mediaItems = mediaItems,
                pagerState = pagerState,
                onEvent = onEvent,
                contentScale = ContentScale.Fit,
                hasBackground = true,
                modifier = Modifier
                    .sharedElement(
                        rememberSharedContentState(key = "media_pager"),
                        animatedVisibilityScope = animatedVisibilityScope
                    )
                    .fillMaxSize()
            )

            AddMediaButton(
                onClick = { onEvent(MediaEvent.EnterSelectionMode) },
                modifier = Modifier
                    .padding(12.dp)
                    .align(Alignment.BottomCenter)
                    .zIndex(1f)
            )

            TopRowExpandedMedia(
                mediaState = state,
                onEvent = onEvent,
                pagerState = pagerState,
                modifier = Modifier.padding(12.dp),
            )
        }
    }
}