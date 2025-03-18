package com.example.alcocalendar.features.session_manage.media.domain.use_case.delete_media

import com.example.alcocalendar.features.session_manage.media.domain.repository.ImageRepository
import javax.inject.Inject

class DeleteMediaUseCase @Inject constructor(
    private val repository: ImageRepository
) {
    suspend operator fun invoke(fileName: String) {
        repository.deleteImage(fileName)
    }
}