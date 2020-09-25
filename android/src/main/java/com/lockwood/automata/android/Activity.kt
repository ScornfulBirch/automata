package com.lockwood.automata.android

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log

fun Context.hasAppsToHandleIntent(
    intent: Intent
): Boolean = intent.resolveActivity(packageManager) != null

fun Context.launchActivity(
    className: String,
    options: Bundle? = null,
    init: Intent.() -> Unit = {}
) {
    val intent = newIntent(this, className)
    intent.init()

    startActivity(intent, options)
}

inline fun <reified T : Any> Context.launchActivity(
    options: Bundle? = null,
    noinline init: Intent.() -> Unit = {}
) {
    val intent = newIntent<T>(this)
    intent.init()

    startActivity(intent, options)
}

inline fun Context.safeLaunchActivity(
    intent: Intent,
    options: Bundle? = null,
    onNoActivityToResolve: () -> Unit = {}
) {
    val hasAppsToHandleIntent = hasAppsToHandleIntent(intent)

    if (!hasAppsToHandleIntent) {
        Log.e("Intent", "Not found app to handle $intent")
        onNoActivityToResolve()
    } else {
        startActivity(intent, options)
    }
}

inline fun Activity.safeLaunchActivityForResult(
    intent: Intent,
    requestCode: Int,
    options: Bundle? = null,
    onNoActivityToResolve: () -> Unit = {}
) {
    val hasAppsToHandleIntent = hasAppsToHandleIntent(intent)

    if (!hasAppsToHandleIntent) {
        Log.e("Intent", "Not found app to handle $intent")
        onNoActivityToResolve()
    } else {
        startActivityForResult(intent, requestCode, options)
    }
}