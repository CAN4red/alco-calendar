package com.example.alcocalendar.features.session_manage.media.domain.use_case.save_media

import com.example.alcocalendar.features.session_manage.media.domain.model.MediaItem
import com.example.alcocalendar.features.session_manage.media.domain.repository.ImageRepository
import javax.inject.Inject

class SaveMediaUseCase @Inject constructor(
    private val repository: ImageRepository
) {
    suspend operator fun invoke(mediaModel: MediaItem): String {
        return repository.saveImage(mediaModel)
    }
}