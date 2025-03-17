package com.example.alcocalendar.features.session_manage.media.data.mappers

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.alcocalendar.features.session_manage.media.data.local.entity.MediaItemEntity
import com.example.alcocalendar.features.session_manage.media.domain.model.MediaItem
import com.example.alcocalendar.features.session_manage.media.domain.model.MediaType
import java.io.File
import java.time.LocalDate

object MediaMapper {

    fun toDomain(date: LocalDate, file: File, mediaType: MediaType): MediaItem {
        return MediaItem(
            date = date,
            name = file.name,
            content = file.readBytes(),
            path = file.path,
            type = mediaType,
            timeStamp = file.lastModified(),
        )
    }

    fun toData(mediaItem: MediaItem) = MediaItemEntity(
        name = mediaItem.name,
        date = mediaItem.date,
        path = mediaItem.path,
    )

    internal fun ByteArray.toBitmap(): Bitmap {
        return BitmapFactory.decodeByteArray(this, 0, this.size)
    }
}