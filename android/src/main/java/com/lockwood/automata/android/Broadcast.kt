package com.lockwood.automata.android

import android.app.PendingIntent
import android.content.Context
import android.content.Intent

inline fun <reified T : Any> Context.buildBroadcastPendingIntent(
    noinline init: Intent.() -> Unit = {},
    requestCode: Int = 0,
    flags: Int = PendingIntent.FLAG_UPDATE_CURRENT
): PendingIntent {
    val intent = newIntent<T>(this)
    intent.init()

    return PendingIntent.getBroadcast(this, requestCode, intent, flags)
}