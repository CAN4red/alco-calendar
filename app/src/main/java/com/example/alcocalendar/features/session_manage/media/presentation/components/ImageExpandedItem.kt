package com.example.alcocalendar.features.session_manage.media.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.core.net.toUri
import coil3.compose.AsyncImage
import com.example.alcocalendar.R
import com.example.alcocalendar.features.session_manage.media.domain.model.MediaItem

@Composable
fun ImageExpandedItem(
    mediaItem: MediaItem,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        AsyncImage(
            model = mediaItem.path?.toUri() ?: "", // TODO: add default uri
            contentDescription = stringResource(R.string.image_media_item),
            modifier = Modifier.fillMaxSize()
        )
    }
}