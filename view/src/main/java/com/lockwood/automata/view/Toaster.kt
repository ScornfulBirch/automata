package com.lockwood.automata.view

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorRes
import com.lockwood.automata.EMPTY
import com.lockwood.automata.resources.color

private const val DEFAULT_TOAST_BACKGROUND_COLOR = android.R.color.darker_gray
private const val DEFAULT_TOAST_TEXT_COLOR = android.R.color.white
private const val DEFAULT_TOAST_LENGTH = Toast.LENGTH_SHORT

private var currentToast: Toast? = null

fun Context.toast(
    toastText: String,
    @ColorRes backgroundTint: Int = DEFAULT_TOAST_BACKGROUND_COLOR,
    @ColorRes textColor: Int = DEFAULT_TOAST_TEXT_COLOR,
    length: Int = DEFAULT_TOAST_LENGTH
) {
    currentToast?.cancel()

    if (toastText.isNotEmpty()) {
        buildToast(toastText, backgroundTint, textColor, length).show()
    }
}

fun Context.longToast(
    toastText: String,
    @ColorRes backgroundTint: Int = DEFAULT_TOAST_BACKGROUND_COLOR,
    @ColorRes textColor: Int = DEFAULT_TOAST_TEXT_COLOR
) = toast(toastText, backgroundTint, textColor, Toast.LENGTH_LONG)

@Suppress("DEPRECATION")
@SuppressLint("ShowToast")
private fun Context.buildToast(
    toastText: String,
    @ColorRes backgroundTint: Int = DEFAULT_TOAST_BACKGROUND_COLOR,
    @ColorRes textColor: Int = DEFAULT_TOAST_TEXT_COLOR,
    length: Int = DEFAULT_TOAST_LENGTH
): Toast {
    val sourceToast: Toast

    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
        sourceToast = Toast.makeText(this, String.EMPTY, length)

        val toastView = requireNotNull(sourceToast.view)
        toastView.applyCustomToast(toastText, backgroundTint, textColor)
    } else {
        sourceToast = Toast.makeText(this, toastText, length)
    }

    currentToast = sourceToast

    return sourceToast
}

private fun View.applyCustomToast(
    toastText: String,
    @ColorRes backgroundTint: Int = DEFAULT_TOAST_BACKGROUND_COLOR,
    @ColorRes textColor: Int = DEFAULT_TOAST_TEXT_COLOR
) {
    val color = context.color(textColor)
    val backgroundColor = context.color(backgroundTint)

    with(this) {
        updateBackgroundColor(backgroundColor)

        val toastTextView = findViewById<TextView>(android.R.id.message)

        with(toastTextView) {
            text = toastText
            setTextColor(color)
        }
    }
}
