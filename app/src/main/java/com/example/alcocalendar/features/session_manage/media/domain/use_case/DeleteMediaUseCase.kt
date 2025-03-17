package com.example.alcocalendar.features.session_manage.media.domain.use_case

import com.example.alcocalendar.features.session_manage.media.domain.repository.ImageRepository
import javax.inject.Inject

class DeleteMediaUseCase @Inject constructor(
    private val repository: ImageRepository
) {
    suspend operator fun invoke(fileName: String): Boolean {
        return repository.deleteImage(fileName)
    }
}