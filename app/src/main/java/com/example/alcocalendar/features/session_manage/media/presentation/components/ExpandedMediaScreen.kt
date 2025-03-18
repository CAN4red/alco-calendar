package com.example.alcocalendar.features.session_manage.media.presentation.components

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.alcocalendar.features.session_manage.media.presentation.MediaEvent
import com.example.alcocalendar.features.session_manage.media.presentation.MediaState
import com.example.alcocalendar.features.session_manage.media.presentation.MediaUtils.getDefaultMediaItem

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ExpandedMediaScreen(
    state: MediaState,
    onEvent: (MediaEvent) -> Unit,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState { state.mediaItems.size.takeIf { it != 0 } ?: 1 }
    val mediaItems = state.mediaItems.ifEmpty { listOf(getDefaultMediaItem(state)) }

    BackHandler {
        onEvent(MediaEvent.CollapseMedia)
    }

    with(sharedTransitionScope) {
        Box(
            modifier = modifier.sharedElement(
                rememberSharedContentState(key = "media_pager"),
                animatedVisibilityScope = animatedVisibilityScope
            )
        ) {

            HorizontalPager(state = pagerState) { mediaIndex ->
                ImageExpandedItem(
                    mediaItem = mediaItems[mediaIndex]
                )
            }
        }
    }
}
