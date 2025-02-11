package com.example.alcocalendar.core.domain.use_case.get_intakes

import com.example.alcocalendar.core.data.local.entities.DrinkIntake
import com.example.alcocalendar.core.domain.repository.SharedDrinkIntakeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.LocalDate
import javax.inject.Inject

class GetDrinkIntakesUseCase @Inject constructor(
    private val sharedRepository: SharedDrinkIntakeRepository
) {
    operator fun invoke(date: LocalDate): Flow<List<DrinkIntake>> = flow {
        emit(sharedRepository.getDrinkIntakesByDate(date))
    }
}