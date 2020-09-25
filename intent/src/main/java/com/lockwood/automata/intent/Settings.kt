package com.lockwood.automata.intent

import android.content.Context
import android.provider.Settings
import com.lockwood.automata.android.buildIntent
import com.lockwood.automata.android.safeLaunchActivity

fun Context.openSettings(
    onFailure: () -> Unit = {}
) {
    val intent = buildIntent(Settings.ACTION_SETTINGS)

    safeLaunchActivity(
        intent = intent,
        onNoActivityToResolve = onFailure
    )
}