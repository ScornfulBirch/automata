package com.lockwood.automata.view

import android.os.Build
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.annotation.StyleRes
import com.lockwood.automata.text.fromHtml

fun TextView.setHtmlText(
    htmlText: String,
    enableLinkMovement: Boolean = false
) {
    text = htmlText.fromHtml()
    enableLinkMovement(enableLinkMovement)
}

fun TextView.enableLinkMovement(
    isEnable: Boolean
) {
    movementMethod = if (isEnable) {
        LinkMovementMethod.getInstance()
    } else {
        null
    }
}

@Suppress("DEPRECATION")
fun TextView.setAppearance(
    @StyleRes style: Int
) = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
    setTextAppearance(style)
} else {
    setTextAppearance(context, style)
}