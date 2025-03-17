package com.example.alcocalendar.features.session_manage.media.domain.repository

import android.graphics.Bitmap
import com.example.alcocalendar.features.session_manage.media.domain.model.MediaModel

interface ImageRepository {
    suspend fun saveImage(bitmap: Bitmap, fileName: String): String
    suspend fun deleteImage(fileName: String): Boolean
    fun getImages(fileNames: List<String>): List<MediaModel>
}
