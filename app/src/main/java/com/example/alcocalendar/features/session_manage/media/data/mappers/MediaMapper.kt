package com.example.alcocalendar.features.session_manage.media.data.mappers

import com.example.alcocalendar.features.session_manage.media.domain.model.MediaModel
import com.example.alcocalendar.features.session_manage.media.domain.model.MediaType
import java.io.File

object MediaMapper {

    fun toDomain(file: File, mediaType: MediaType): MediaModel {
        return MediaModel(
            name = file.name,
            path = file.path,
            type = mediaType,
            timeStamp = file.lastModified(),
        )
    }
}