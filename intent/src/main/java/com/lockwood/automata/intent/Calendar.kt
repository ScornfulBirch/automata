package com.lockwood.automata.intent

import android.content.Context
import android.content.Intent
import android.provider.CalendarContract
import com.lockwood.automata.android.buildIntent
import com.lockwood.automata.android.safeLaunchActivity

fun Context.addCalendarEvent(
    title: String,
    location: String,
    begin: Long,
    end: Long,
    onFailure: () -> Unit = {}
) {
    val intent = buildIntent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI) {
        putExtra(CalendarContract.Events.TITLE, title)
        putExtra(CalendarContract.Events.EVENT_LOCATION, location)
        putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
        putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end)
    }

    safeLaunchActivity(
        intent = intent,
        onNoActivityToResolve = onFailure
    )
}