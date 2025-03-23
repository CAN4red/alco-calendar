package com.example.alcocalendar.features.session_manage.common.mappers

import com.example.alcocalendar.features.session_manage.media.domain.model.MediaItem
import com.example.alcocalendar.features.session_manage.media.domain.model.MediaType
import java.io.File
import java.time.LocalDate

object MediaMapper {

    fun toDomain(date: LocalDate, file: File, mediaType: MediaType): MediaItem {

        return MediaItem(
            date = date,
            name = file.name,
            path = file.path,
            type = mediaType,
            timeStamp = file.lastModified(),
        )
    }
}