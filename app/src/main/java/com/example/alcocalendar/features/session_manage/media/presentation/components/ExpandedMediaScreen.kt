package com.example.alcocalendar.features.session_manage.media.presentation.components

import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
    val mediaItems = state.mediaItems.ifEmpty { listOf(getDefaultMediaItem(state)) }
    val pagerState = rememberPagerState { state.mediaItems.size.takeIf { it != 0 } ?: 1 }
    val mediaPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickMultipleVisualMedia(),
        onResult = { uris ->
            onEvent(MediaEvent.SaveMedia(uris))
            onEvent(MediaEvent.ExitSelectionMode)
        }
    )


    BackHandler {
        onEvent(MediaEvent.CollapseMedia)
    }

    LaunchedEffect(state.isInSelectionMode) {
        if (state.isInSelectionMode) {
            mediaPickerLauncher.launch(
                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
            )
        }
    }

    with(sharedTransitionScope) {
        Box(
            modifier = modifier
                .sharedElement(
                    rememberSharedContentState(key = "media_pager"),
                    animatedVisibilityScope = animatedVisibilityScope
                )
                .clickable { onEvent(MediaEvent.EnterSelectionMode) }
        ) {
            HorizontalPager(state = pagerState) { mediaIndex ->
                ImageExpandedItem(
                    mediaItem = mediaItems[mediaIndex]
                )
            }
        }
    }
}
