package com.example.alcocalendar.features.session_manage.media.domain.use_case

import com.example.alcocalendar.features.session_manage.media.domain.model.MediaModel
import com.example.alcocalendar.features.session_manage.media.domain.repository.ImageRepository
import javax.inject.Inject

class SaveMediaUseCase @Inject constructor(
    private val repository: ImageRepository
) {
    suspend operator fun invoke(mediaModel: MediaModel): String {
        return repository.saveImage(mediaModel)
    }
}
