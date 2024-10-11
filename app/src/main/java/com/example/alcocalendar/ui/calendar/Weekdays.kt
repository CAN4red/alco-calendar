package com.example.alcocalendar.ui.calendar

enum class Weekdays(val index: Int) {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    companion object {
        fun fromString(day: String): Weekdays {
            return when (day.lowercase()) {
                "monday" -> MONDAY
                "tuesday" -> TUESDAY
                "wednesday" -> WEDNESDAY
                "thursday" -> THURSDAY
                "friday" -> FRIDAY
                "saturday" -> SATURDAY
                "sunday" -> SUNDAY
                else -> throw IllegalArgumentException("Invalid day: $day")
            }
        }
    }
}
