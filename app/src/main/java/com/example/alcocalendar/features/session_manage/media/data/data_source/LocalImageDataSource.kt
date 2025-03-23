package com.example.alcocalendar.features.session_manage.media.data.data_source

import android.content.Context
import android.net.Uri
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okio.IOException
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject

class LocalImageDataSource @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val storageDir = context.filesDir
    private val mediaDir = File(storageDir, "media")

    suspend fun saveImage(externalUri: Uri, fileName: String): String {
        val inputStream = context.contentResolver.openInputStream(externalUri)
            ?: throw IOException("Failed to open stream to save image")

        mediaDir.mkdirs()
        val internalFile = File(mediaDir, fileName)

        try {
            withContext(Dispatchers.IO) {
                inputStream.use { input ->
                    FileOutputStream(internalFile).use { output ->
                        input.copyTo(output)
                    }
                }
            }
            return internalFile.absolutePath
        } catch (exception: Exception) {
            internalFile.delete()
            throw exception
        }
    }

    fun getImages(fileNames: List<String>): List<File> {
        val fileNamesSet = fileNames.toSet()
        return mediaDir.listFiles { file, fileName ->
            fileName in fileNamesSet
        }?.toList() ?: emptyList()
    }

    suspend fun deleteImage(fileName: String): Boolean {
        return withContext(Dispatchers.IO) {
            val file = File(mediaDir, fileName)
            file.delete()
        }
    }
}
