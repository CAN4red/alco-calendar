package com.example.alcocalendar.features.session_manage.media.domain.use_case.get_media

import com.example.alcocalendar.features.session_manage.media.domain.model.MediaItem
import com.example.alcocalendar.features.session_manage.media.domain.repository.ImageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.LocalDate
import javax.inject.Inject

class GetMediaUseCase @Inject constructor(
    private val repository: ImageRepository
) {
    operator fun invoke(date: LocalDate): Flow<List<MediaItem>> = flow {
        emit(emptyList())
        emit(repository.getImages(date))
    }
}