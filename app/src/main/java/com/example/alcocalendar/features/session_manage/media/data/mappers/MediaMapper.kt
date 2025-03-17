package com.example.alcocalendar.features.session_manage.media.data.mappers

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.alcocalendar.features.session_manage.media.domain.model.MediaModel
import com.example.alcocalendar.features.session_manage.media.domain.model.MediaType
import java.io.File

object MediaMapper {

    fun toDomain(file: File, mediaType: MediaType): MediaModel {
        return MediaModel(
            name = file.name,
            content = file.readBytes(),
            path = file.path,
            type = mediaType,
            timeStamp = file.lastModified(),
        )
    }

    internal fun ByteArray.toBitmap(): Bitmap {
        return BitmapFactory.decodeByteArray(this, 0, this.size)
    }
}