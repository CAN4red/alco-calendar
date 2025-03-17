package com.example.alcocalendar.features.session_manage.media.data.data_source

import android.content.Context
import android.graphics.Bitmap
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject

class LocalImageDataSource @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val storageDir = context.filesDir

    suspend fun saveImage(bitmap: Bitmap, fileName: String): String {
        return withContext(Dispatchers.IO) {
            val file = File(storageDir, fileName)
            FileOutputStream(file).use { stream ->
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
            }
            file.absolutePath
        }
    }

    fun getImages(fileNames: List<String>): List<File> {
        val fileNamesSet = fileNames.toSet()
        return storageDir.listFiles { file, fileName ->
            fileName in fileNamesSet
        }?.toList() ?: emptyList()
    }

    suspend fun deleteImage(fileName: String): Boolean {
        return withContext(Dispatchers.IO) {
            val file = File(storageDir, fileName)
            file.delete()
        }
    }
}
