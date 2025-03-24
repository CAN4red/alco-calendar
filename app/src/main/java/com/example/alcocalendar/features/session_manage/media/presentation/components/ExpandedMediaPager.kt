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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.example.alcocalendar.features.session_manage.media.presentation.MediaEvent
import com.example.alcocalendar.features.session_manage.media.presentation.MediaState

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ExpandedMediaScreen(
    state: MediaState,
    onEvent: (MediaEvent) -> Unit,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
    modifier: Modifier = Modifier
) {
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

    Box(
        modifier = modifier
    ) {
        with(sharedTransitionScope) {
            MediaPager(
                state = state,
                onEvent = onEvent,
                contentScale = ContentScale.Fit,
                hasBackground = true,
                modifier = Modifier
                    .sharedElement(
                        rememberSharedContentState(key = "media_pager"),
                        animatedVisibilityScope = animatedVisibilityScope
                    )
                    .fillMaxSize()
                    .clickable { onEvent(MediaEvent.EnterSelectionMode) }
            )
        }
    }
}
