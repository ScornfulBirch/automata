package com.lockwood.automata.view

import androidx.appcompat.widget.AppCompatTextView
import androidx.core.text.PrecomputedTextCompat
import androidx.core.widget.TextViewCompat

fun AppCompatTextView.asyncText(
    text: CharSequence
) {
    val params = TextViewCompat.getTextMetricsParams(this)
    val future = PrecomputedTextCompat.getTextFuture(text, params, null)

    setTextFuture(future)
}