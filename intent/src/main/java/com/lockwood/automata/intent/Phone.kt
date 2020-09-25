package com.lockwood.automata.intent

import android.Manifest.permission.CALL_PHONE
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.annotation.RequiresPermission
import com.lockwood.automata.android.buildIntent
import com.lockwood.automata.android.safeLaunchActivity

fun Context.dialPhoneNumber(
    phoneNumber: String,
    onFailure: () -> Unit = {}
) {
    val uri = Uri.parse("tel:$phoneNumber")

    val intent = buildIntent(Intent.ACTION_DIAL, uri)

    safeLaunchActivity(
        intent = intent,
        onNoActivityToResolve = onFailure
    )
}

@RequiresPermission(CALL_PHONE)
fun Context.callPhoneNumber(
    phoneNumber: String,
    onFailure: () -> Unit = {}
) {
    val uri = Uri.parse("tel:$phoneNumber")

    val intent = buildIntent(Intent.ACTION_CALL, uri)

    safeLaunchActivity(
        intent = intent,
        onNoActivityToResolve = onFailure
    )
}