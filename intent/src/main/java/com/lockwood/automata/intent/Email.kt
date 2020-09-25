package com.lockwood.automata.intent

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.lockwood.automata.EMPTY
import com.lockwood.automata.android.buildIntent
import com.lockwood.automata.android.safeLaunchActivity

fun Context.composeEmail(
    address: String,
    subject: String,
    body: String = String.EMPTY,
    onFailure: () -> Unit = {}
) {
    val mailUri = StringBuilder("mailto:$address?subject=$subject")

    if (body.isNotEmpty()) {
        val bodyWithLines = body.replace("\n", "<br>")
        mailUri.append("&body=$bodyWithLines")
    }

    val resultMailUri = Uri.parse(mailUri.toString())

    val intent = buildIntent(Intent.ACTION_SENDTO, resultMailUri)

    safeLaunchActivity(
        intent = intent,
        onNoActivityToResolve = onFailure
    )
}

fun Context.composeEmail(
    address: String,
    subject: String,
    vararg attachments: Uri,
    onFailure: () -> Unit = {}
) = composeEmail(
    addresses = arrayOf(address),
    subject = subject,
    attachments = *attachments,
    onFailure = onFailure
)

fun Context.composeEmail(
    addresses: Array<String>,
    subject: String,
    vararg attachments: Uri,
    onFailure: () -> Unit = {}
) {
    val sendAction = if (attachments.size == 1) {
        Intent.ACTION_SEND
    } else {
        Intent.ACTION_SEND_MULTIPLE
    }

    val intent = buildIntent(sendAction) {
        type = "*/*"
        putExtra(Intent.EXTRA_EMAIL, addresses)
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_STREAM, attachments)
    }

    safeLaunchActivity(
        intent = intent,
        onNoActivityToResolve = onFailure
    )
}
