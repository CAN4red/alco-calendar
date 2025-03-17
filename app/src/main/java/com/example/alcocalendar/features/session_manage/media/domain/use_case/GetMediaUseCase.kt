package com.example.alcocalendar.features.session_manage.media.domain.use_case

import com.example.alcocalendar.features.session_manage.media.domain.model.MediaModel
import com.example.alcocalendar.features.session_manage.media.domain.repository.ImageRepository
import javax.inject.Inject

class GetMediaUseCase @Inject constructor(
    private val repository: ImageRepository
) {
    suspend operator fun invoke(fileNames: List<String>): List<MediaModel> {
        return repository.getImages(fileNames)
    }
}