package com.example.alcocalendar.features.session_manage

import androidx.lifecycle.SavedStateHandle
import com.example.alcocalendar.core.navigation.NavArgs
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.utils.StringToDateMapper.toDay
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.utils.StringToDateMapper.toMonth
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.utils.StringToDateMapper.toYear
import java.time.LocalDate

object SessionManageUtils {

    fun SavedStateHandle.getDate(): LocalDate {
        val year = this.get<String>(NavArgs.YEAR).toYear()
        val month = this.get<String>(NavArgs.MONTH).toMonth()
        val day = this.get<String>(NavArgs.DAY).toDay()

        return LocalDate.of(year, month, day)
    }
}