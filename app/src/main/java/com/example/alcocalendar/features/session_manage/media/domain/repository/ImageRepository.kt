package com.example.alcocalendar.features.session_manage.media.domain.repository

import com.example.alcocalendar.features.session_manage.media.domain.model.MediaModel

interface ImageRepository {
    suspend fun saveImage(mediaModel: MediaModel): String
    suspend fun deleteImage(fileName: String): Boolean
    fun getImages(fileNames: List<String>): List<MediaModel>
}
