package com.example.alcocalendar.features.session_manage.media.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.example.alcocalendar.R
import com.example.alcocalendar.features.session_manage.media.domain.model.MediaItem
import com.example.alcocalendar.features.session_manage.media.domain.model.MediaType

object MediaUtils {

    @Composable
    fun getDefaultMediaItem(state: MediaState): MediaItem {
        val context = LocalContext.current
        val drawableResourceId = R.drawable.default_media

        return MediaItem(
            date = state.date,
            name = stringResource(R.string.default_media_item),
            path = "android.resource://${context.packageName}/$drawableResourceId",
            type = MediaType.IMAGE,
        )
    }
}