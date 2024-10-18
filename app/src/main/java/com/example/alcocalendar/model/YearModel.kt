package com.example.alcocalendar.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Month


class YearModel(
    val year: Int,
    private val january: MonthModel,
    private val february: MonthModel,
    private val march: MonthModel,
    private val april: MonthModel,
    private val may: MonthModel,
    private val june: MonthModel,
    private val july: MonthModel,
    private val august: MonthModel,
    private val september: MonthModel,
    private val october: MonthModel,
    private val november: MonthModel,
    private val december: MonthModel,
) {
    @RequiresApi(Build.VERSION_CODES.O)
    constructor(year: Int) : this(
        year = year,
        january = MonthModel(year, Month.JANUARY),
        february = MonthModel(year, Month.FEBRUARY),
        march = MonthModel(year, Month.MARCH),
        april = MonthModel(year, Month.APRIL),
        may = MonthModel(year, Month.MAY),
        june = MonthModel(year, Month.JUNE),
        july = MonthModel(year, Month.JULY),
        august = MonthModel(year, Month.AUGUST),
        september = MonthModel(year, Month.SEPTEMBER),
        october = MonthModel(year, Month.OCTOBER),
        november = MonthModel(year, Month.NOVEMBER),
        december = MonthModel(year, Month.DECEMBER)
    )

    @RequiresApi(Build.VERSION_CODES.O)
    fun getMonthModel(month: Month): MonthModel {
        return when (month) {
            Month.JANUARY -> january
            Month.FEBRUARY -> february
            Month.MARCH -> march
            Month.APRIL -> april
            Month.MAY -> may
            Month.JUNE -> june
            Month.JULY -> july
            Month.AUGUST -> august
            Month.SEPTEMBER -> september
            Month.OCTOBER -> october
            Month.NOVEMBER -> november
            Month.DECEMBER -> december
        }
    }
}
