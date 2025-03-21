package com.example.alcocalendar.features.session_manage.media.data.repository

import androidx.core.net.toUri
import com.example.alcocalendar.features.session_manage.common.mappers.MediaMapper
import com.example.alcocalendar.features.session_manage.media.data.data_source.LocalImageDataSource
import com.example.alcocalendar.features.session_manage.media.data.local.dao.MediaDao
import com.example.alcocalendar.features.session_manage.media.data.local.entity.MediaItemEntity
import com.example.alcocalendar.features.session_manage.media.domain.model.MediaItem
import com.example.alcocalendar.features.session_manage.media.domain.model.MediaType
import com.example.alcocalendar.features.session_manage.media.domain.repository.ImageRepository
import java.time.LocalDate
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val localImageDataSource: LocalImageDataSource,
    private val mediaDao: MediaDao,
) : ImageRepository {
    override suspend fun saveImage(externalPath: String, date: LocalDate) {
        val filePath = localImageDataSource.saveImage(
            externalUri = externalPath.toUri(),
            fileName = externalPath.toString(),
        )
        val mediaItemEntity = MediaItemEntity(
            name = externalPath.toString(),
            date = date,
            path = filePath
        )
        mediaDao.insertMediaItem(mediaItemEntity)
    }

    override suspend fun deleteImage(fileName: String) {
        mediaDao.deleteMediaItemByName(fileName)
        localImageDataSource.deleteImage(fileName)
    }

    override suspend fun getImages(date: LocalDate): List<MediaItem> {
        val mediaItemNames =
            mediaDao.getDrinkingSessionWithMediaItems(date).mediaItems.map { it.name }

        return localImageDataSource.getImages(mediaItemNames).map { file ->
            MediaMapper.toDomain(
                date = date,
                file = file,
                mediaType = MediaType.IMAGE
            )
        }
    }
}
