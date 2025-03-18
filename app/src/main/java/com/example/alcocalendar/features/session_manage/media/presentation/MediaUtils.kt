package com.example.alcocalendar.features.session_manage.media.presentation

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.core.content.ContextCompat
import com.example.alcocalendar.R
import com.example.alcocalendar.features.session_manage.media.domain.model.MediaItem
import com.example.alcocalendar.features.session_manage.media.domain.model.MediaType
import java.io.ByteArrayOutputStream

object MediaUtils {

    @Composable
    fun getDefaultMediaItem(state: MediaState): MediaItem {
        val context = LocalContext.current
        val defaultMediaBytes = remember {
            convertDrawableToByteArray(context, R.drawable.default_media)
        }

        return MediaItem(
            date = state.date,
            name = stringResource(R.string.default_media_item),
            content = defaultMediaBytes,
            type = MediaType.IMAGE,
        )
    }

    private fun convertDrawableToByteArray(
        context: Context,
        @DrawableRes drawableId: Int
    ): ByteArray {
        val drawable = ContextCompat.getDrawable(context, drawableId)
        val bitmap = (drawable as BitmapDrawable).bitmap
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
        return stream.toByteArray()
    }
}