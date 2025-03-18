package com.example.alcocalendar.features.session_manage.media.data.repository

import com.example.alcocalendar.features.session_manage.media.data.data_source.LocalImageDataSource
import com.example.alcocalendar.features.session_manage.media.data.local.dao.MediaDao
import com.example.alcocalendar.features.session_manage.common.mappers.MediaMapper
import com.example.alcocalendar.features.session_manage.common.mappers.MediaMapper.toBitmap
import com.example.alcocalendar.features.session_manage.media.domain.model.MediaItem
import com.example.alcocalendar.features.session_manage.media.domain.model.MediaType
import com.example.alcocalendar.features.session_manage.media.domain.repository.ImageRepository
import java.time.LocalDate
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val localImageDataSource: LocalImageDataSource,
    private val mediaDao: MediaDao,
) : ImageRepository {
    override suspend fun saveImage(mediaItem: MediaItem) {
        val path = localImageDataSource.saveImage(
            bitmap = mediaItem.content.toBitmap(),
            fileName = mediaItem.name,
        )
        mediaDao.insertMediaItem(MediaMapper.toData(mediaItem).copy(path = path))
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
