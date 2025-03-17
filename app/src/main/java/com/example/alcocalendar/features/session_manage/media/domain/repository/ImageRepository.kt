package com.example.alcocalendar.features.session_manage.media.domain.repository

import com.example.alcocalendar.features.session_manage.media.domain.model.MediaItem
import java.time.LocalDate

interface ImageRepository {
    suspend fun saveImage(mediaItem: MediaItem): String
    suspend fun deleteImage(fileName: String): Boolean
    suspend fun getImages(date: LocalDate): List<MediaItem>
}
