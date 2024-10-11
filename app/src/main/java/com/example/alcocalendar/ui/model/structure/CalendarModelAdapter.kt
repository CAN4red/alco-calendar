package com.example.alcocalendar.ui.model.structure
//
//import android.annotation.SuppressLint
//import android.util.Log
//import com.example.alcocalendar.ui.model.MonthModel
//import com.example.alcocalendar.ui.model.YearModel
//
//import java.time.Month
//
//class CalendarModelAdapter(
//    private val calendarState: CalendarState
//) : CalendarProvider {
//
//    override val initialYear: Int = calendarState.initialYearIndex
//    override val initialMonth: Month = calendarState.initialMonthIndex
//    override val yearsCount: Int = calendarState.yearsCount
//    override val monthsCount: Int = calendarState.monthsCount
//
//    fun updateCalendarState(
//        year: Int,
//        month: Month? = calendarState.currentMonth
//    ) {
//        calendarState.apply {
//            currentYear = currentYear ?: initialYearIndex
//            currentMonth = currentMonth ?: initialMonthIndex
//
//            currentYear = year
//            currentMonth = month
//        }
//    }
//
//    fun getMonthIndex(): Int {
//        return monthToIndex(
//            year = calendarState.currentYear ?: calendarState.initialYearIndex,
//            month = calendarState.currentMonth ?: calendarState.initialMonthIndex
//        )
//    }
//
//    fun getYearIndex(): Int {
//        return yearToIndex(
//            year = calendarState.currentYear ?: calendarState.initialYearIndex
//        )
//    }
//
//    override fun getMonthModel(index: Int): MonthModel {
//        Log.d("lool", index.toString())
//        return calendarState.getMonthModel(
//            year = indexToYearForMonth(index),
//            month = indexToMonth(index)
//        )
//    }
//
//    override fun getYearModel(index: Int): YearModel {
//        return calendarState.getYearModel(
//            year = indexToYear(index)
//        )
//    }
//
//    override fun hasNextMonth(index: Int): Boolean {
//        return calendarState.hasNextMonth(
//            year = indexToYearForMonth(index),
//            month = indexToMonth(index)
//        )
//    }
//
//    override fun hasPreviousMonth(index: Int): Boolean {
//        return calendarState.hasPreviousMonth(
//            year = indexToYearForMonth(index),
//            month = indexToMonth(index)
//        )
//    }
//
//    override fun hasNextYear(index: Int): Boolean {
//        return calendarState.hasNextYear(
//            year = indexToYear(index)
//        )
//    }
//
//    override fun hasPreviousYear(index: Int): Boolean {
//        return calendarState.hasPreviousYear(
//            year = indexToYear(index)
//        )
//    }
//
//    @SuppressLint("NewApi")
//    fun indexToMonth(index: Int): Month {
//        return Month.of(index % MONTHS_NUMBER + 1)
//    }
//
//    fun monthToIndex(year: Int, month: Month): Int {
//        return (year - FIRST_YEAR) * MONTHS_NUMBER + month.ordinal
//    }
//
//    fun indexToYearForMonth(index: Int): Int {
//        return (index / MONTHS_NUMBER) + FIRST_YEAR
//    }
//
//    fun indexToYear(index: Int): Int {
//        return index + FIRST_YEAR
//    }
//
//    fun yearToIndex(year: Int): Int {
//        return year - FIRST_YEAR
//    }
//
//    companion object {
//        private const val FIRST_YEAR = 2000
//        private const val MONTHS_NUMBER = 12
//    }
//}
