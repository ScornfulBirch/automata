package com.lockwood.automata.text

import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat

@Suppress("DEPRECATION")
fun String.fromHtml(): Spanned = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
    HtmlCompat.fromHtml(this, HtmlCompat.FROM_HTML_MODE_COMPACT)
} else {
    Html.fromHtml(this)
}