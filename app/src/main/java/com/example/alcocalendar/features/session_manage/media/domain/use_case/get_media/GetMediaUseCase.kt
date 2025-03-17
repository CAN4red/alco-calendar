package com.example.alcocalendar.features.session_manage.media.domain.use_case.get_media

import com.example.alcocalendar.features.session_manage.media.domain.model.MediaItem
import com.example.alcocalendar.features.session_manage.media.domain.repository.ImageRepository
import java.time.LocalDate
import javax.inject.Inject

class GetMediaUseCase @Inject constructor(
    private val repository: ImageRepository
) {
    suspend operator fun invoke(date: LocalDate): List<MediaItem> {
        return repository.getImages(date)
    }
}