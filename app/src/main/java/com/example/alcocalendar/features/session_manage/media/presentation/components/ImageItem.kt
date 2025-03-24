package com.example.alcocalendar.features.session_manage.media.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.core.net.toUri
import coil3.compose.AsyncImage
import com.example.alcocalendar.R
import com.example.alcocalendar.features.session_manage.media.domain.model.MediaItem

@Composable
fun ImageItem(
    mediaItem: MediaItem,
    contentScale: ContentScale,
    modifier: Modifier = Modifier,
    hasBackground: Boolean = false,
) {
    Box(modifier = modifier) {
        AsyncImage(
            model = mediaItem.path?.toUri() ?: "", // TODO: add default uri
            contentDescription = stringResource(R.string.image_media_item),
            contentScale = contentScale,
            modifier = Modifier
                .fillMaxSize()
                .zIndex(1f)
        )

        if (hasBackground) {
            AsyncImage(
                model = mediaItem.path?.toUri() ?: "", // TODO: add default uri
                contentDescription = stringResource(R.string.image_media_item),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .blur(12.dp)
                    .zIndex(0f)
            )
        }
    }
}