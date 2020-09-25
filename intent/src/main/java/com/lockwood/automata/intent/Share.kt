package com.lockwood.automata.intent

import android.content.Context
import android.content.Intent
import com.lockwood.automata.android.buildIntent

fun Context.shareText(
    text: String
) {
    val sendIntent = buildIntent(Intent.ACTION_SEND) {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, text)
    }

    val shareIntent = Intent.createChooser(sendIntent, null)

    startActivity(shareIntent)
}