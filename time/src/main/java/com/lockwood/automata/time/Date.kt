package com.lockwood.automata.time

import android.util.Log
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

private const val PATTERN_DATE_FORMAT_SHOW = "dd.MM.yyyy"

fun Date.toCalendar(): Calendar = Calendar.getInstance().init(time)

fun String.parseDate(
    parseFormat: String = PATTERN_DATE_FORMAT_SHOW
): Date? = try {
    val format = SimpleDateFormat(parseFormat, Locale.ENGLISH)
    format.parse(this)
} catch (e: ParseException) {
    Log.e("Date", e.message.toString())
    null
}
