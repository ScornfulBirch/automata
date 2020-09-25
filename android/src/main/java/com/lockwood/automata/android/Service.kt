package com.lockwood.automata.android

import android.content.Context
import android.content.Intent
import android.util.Log

inline fun <reified T : Any> Context.startService(
    noinline init: Intent.() -> Unit = {}
) {
    val intent = newIntent<T>(this)
    intent.init()

    try {
        startService(intent)
    } catch (e: IllegalStateException) {
        Log.e("Service", e.message.toString())
    }
}