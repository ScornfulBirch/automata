package com.lockwood.automata.time

import java.util.*

var Calendar.day
    get() = get(Calendar.DAY_OF_MONTH)
    set(value) {
        set(Calendar.DAY_OF_MONTH, value)
    }

var Calendar.dayOfWeek
    get() = get(Calendar.DAY_OF_WEEK)
    set(value) {
        set(Calendar.DAY_OF_WEEK, value)
    }

var Calendar.month
    get() = get(Calendar.MONTH)
    set(value) {
        set(Calendar.MONTH, value)
    }

var Calendar.year
    get() = get(Calendar.YEAR)
    set(value) {
        set(Calendar.YEAR, value)
    }

var Calendar.era
    get() = get(Calendar.ERA)
    set(value) {
        set(Calendar.ERA, value)
    }

var Calendar.date
    get() = get(Calendar.DATE)
    set(value) {
        set(Calendar.DATE, value)
    }

fun Calendar.init(
    yearToSet: Int,
    monthToSet: Int,
    dayToSet: Int
): Calendar {
    year = yearToSet
    month = monthToSet
    day = dayToSet
    return this
}

fun Calendar.init(
    time: Long
): Calendar {
    timeInMillis = time
    return this
}

fun Calendar.copy(): Calendar {
    val time = timeInMillis
    return Calendar.getInstance().init(time)
}