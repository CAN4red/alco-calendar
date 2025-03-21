package com.example.alcocalendar.features.session_manage.media.domain.use_case.save_media

import com.example.alcocalendar.features.session_manage.media.domain.repository.ImageRepository
import java.time.LocalDate
import javax.inject.Inject

class SaveMediaUseCase @Inject constructor(
    private val repository: ImageRepository
) {
    suspend operator fun invoke(externalPath: String, date: LocalDate) {
        repository.saveImage(externalPath, date)
    }
}