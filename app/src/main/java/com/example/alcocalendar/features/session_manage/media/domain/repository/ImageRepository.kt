package com.example.alcocalendar.features.session_manage.media.domain.repository

import com.example.alcocalendar.features.session_manage.media.domain.model.MediaItem
import java.time.LocalDate

interface ImageRepository {
    suspend fun saveImage(externalPath: String, date: LocalDate)
    suspend fun deleteImage(fileName: String)
    suspend fun getImages(date: LocalDate): List<MediaItem>
}
