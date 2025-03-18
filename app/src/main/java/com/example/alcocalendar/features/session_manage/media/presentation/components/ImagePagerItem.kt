package com.example.alcocalendar.features.session_manage.media.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import com.example.alcocalendar.R
import com.example.alcocalendar.features.session_manage.common.mappers.MediaMapper.toBitmap
import com.example.alcocalendar.features.session_manage.media.domain.model.MediaItem

@Composable
fun ImagePagerItem(
    mediaItem: MediaItem,
    modifier: Modifier = Modifier
) {
    val bitmap = remember(mediaItem.content) {
        mediaItem.content.toBitmap()
    }

    Box(
        modifier = modifier
            .aspectRatio(1f)
            .clipToBounds()
    ) {
        Image(
            bitmap = bitmap.asImageBitmap(),
            contentDescription = stringResource(R.string.image_media_item),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}