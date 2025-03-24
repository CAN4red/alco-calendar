package com.example.alcocalendar.features.session_manage.media.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.R
import com.example.alcocalendar.core.presentation.components.BackButton
import com.example.alcocalendar.features.session_manage.media.domain.model.MediaItem
import com.example.alcocalendar.features.session_manage.media.domain.model.MediaType
import com.example.alcocalendar.features.session_manage.media.presentation.MediaEvent
import com.example.alcocalendar.features.session_manage.media.presentation.MediaState
import java.time.LocalDate

@Composable
fun TopRowExpandedMedia(
    mediaState: MediaState,
    onEvent: (MediaEvent) -> Unit,
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    val selectedMediaItem = getSelectedMediaItem(mediaState)
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ) {
        BackButton(
            onClick = { onEvent(MediaEvent.CollapseMedia) },
            modifier = Modifier.size(32.dp)
        )

        PageIndicator(pagerState = pagerState)

        IconButton(
            onClick = { onEvent(MediaEvent.DeleteMedia(selectedMediaItem)) },
            enabled = mediaState.mediaItems.isNotEmpty(),
            modifier = Modifier.size(32.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = stringResource(R.string.delete_media_button),
                tint = MaterialTheme.colorScheme.onBackground,
            )
        }
    }
}

private fun getSelectedMediaItem(mediaState: MediaState): MediaItem? {
    if (mediaState.mediaItems.isEmpty()) {
        return null
    }
    return try {
        mediaState.mediaItems[mediaState.selectedPage]
    } catch (_: IndexOutOfBoundsException) {
        mediaState.mediaItems[mediaState.selectedPage - 1] // handling last media deletion
    }
}

@Preview
@Composable
private fun TopRowExpandedMediaPreview() {
    TopRowExpandedMedia(
        mediaState = MediaState(
            mediaItems = listOf(
                MediaItem(
                    date = LocalDate.now(),
                    name = "lol",
                    type = MediaType.IMAGE,
                )
            ),
        ),
        onEvent = {},
        pagerState = rememberPagerState { 2 }
    )
}