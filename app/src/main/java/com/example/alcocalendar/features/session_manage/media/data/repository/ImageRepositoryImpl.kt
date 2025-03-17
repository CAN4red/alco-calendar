package com.example.alcocalendar.features.session_manage.media.data.repository

import android.graphics.Bitmap
import com.example.alcocalendar.features.session_manage.media.data.data_source.LocalImageDataSource
import com.example.alcocalendar.features.session_manage.media.data.mappers.MediaMapper
import com.example.alcocalendar.features.session_manage.media.domain.model.MediaModel
import com.example.alcocalendar.features.session_manage.media.domain.model.MediaType
import com.example.alcocalendar.features.session_manage.media.domain.repository.ImageRepository
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val localImageDataSource: LocalImageDataSource,
) : ImageRepository {
    override suspend fun saveImage(bitmap: Bitmap, fileName: String): String {
        return localImageDataSource.saveImage(bitmap, fileName)
    }

    override suspend fun deleteImage(fileName: String): Boolean {
        return localImageDataSource.deleteImage(fileName)
    }

    override fun getImages(fileNames: List<String>): List<MediaModel> {
        return localImageDataSource.getImages(fileNames).map { file ->
            MediaMapper.toDomain(file, MediaType.IMAGE)
        }
    }
}
