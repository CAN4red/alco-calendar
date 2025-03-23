package com.example.alcocalendar.features.session_manage.media.data.repository

import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import androidx.core.net.toUri
import com.example.alcocalendar.features.session_manage.common.mappers.MediaMapper
import com.example.alcocalendar.features.session_manage.media.data.data_source.LocalImageDataSource
import com.example.alcocalendar.features.session_manage.media.data.local.dao.MediaDao
import com.example.alcocalendar.features.session_manage.media.data.local.entity.MediaItemEntity
import com.example.alcocalendar.features.session_manage.media.domain.model.MediaItem
import com.example.alcocalendar.features.session_manage.media.domain.model.MediaType
import com.example.alcocalendar.features.session_manage.media.domain.repository.ImageRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.time.LocalDate
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val localImageDataSource: LocalImageDataSource,
    private val mediaDao: MediaDao,
    @ApplicationContext private val context: Context
) : ImageRepository {
    override suspend fun saveImage(externalPath: String, date: LocalDate) {
        val externalUri = externalPath.toUri()
        val fileName =
            getDisplayNameFromUriAndDate(externalUri, date)?.sanitize() ?: externalPath.sanitize()

        val filePath = localImageDataSource.saveImage(
            externalUri = externalUri,
            fileName = fileName,
        )
        val mediaItemEntity = MediaItemEntity(
            name = fileName,
            date = date,
            path = filePath
        )
        mediaDao.insertMediaItem(mediaItemEntity)
    }

    override suspend fun deleteImage(fileName: String) {
        mediaDao.deleteMediaItemByName(fileName)
        localImageDataSource.deleteImage(fileName)
    }

    override fun getImages(date: LocalDate): Flow<List<MediaItem>> {
        return mediaDao.getDrinkingSessionWithMediaItems(date)
            .map { drinkingSession ->
                val mediaItemNames = drinkingSession.mediaItems.map { it.name }
                val imageFiles = withContext(Dispatchers.IO) {
                    localImageDataSource.getImages(mediaItemNames)
                }
                imageFiles.map { file ->
                    MediaMapper.toDomain(
                        date = date,
                        file = file,
                        mediaType = MediaType.IMAGE
                    )
                }
            }
    }

    private fun getDisplayNameFromUriAndDate(uri: Uri, date: LocalDate): String? {
        return context.contentResolver.query(uri, null, null, null, null)?.use { cursor ->
            if (cursor.moveToFirst()) {
                val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                if (nameIndex != -1) date.toFileNamePrefix() + cursor.getString(nameIndex) else null
            } else null
        }
    }

    private fun String.sanitize(): String {
        return this.replace("[^a-zA-Z0-9-_.]".toRegex(), "_")
    }

    private fun LocalDate.toFileNamePrefix() = "$this-"
}
