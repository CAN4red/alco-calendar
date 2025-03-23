package com.example.alcocalendar.features.session_manage.media.domain.repository

import com.example.alcocalendar.features.session_manage.media.domain.model.MediaItem
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface ImageRepository {
    suspend fun saveImage(externalPath: String, date: LocalDate)
    suspend fun deleteImage(fileName: String)
    fun getImages(date: LocalDate): Flow<List<MediaItem>>
}
