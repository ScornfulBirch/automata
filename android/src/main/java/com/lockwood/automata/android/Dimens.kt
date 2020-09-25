package com.lockwood.automata.android

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics
import androidx.annotation.Px

private const val DEFAULT_VIEW_SIZE = 0

private val Context.densityDpi: Float
    get() = resources.displayMetrics.densityDpi.toFloat()

private val Context.densityScale: Float
    get() = densityDpi / DisplayMetrics.DENSITY_DEFAULT

val Resources.navBarHeight: Int
    @Px
    get() {
        val resourceId = getIdentifier(
            "navigation_bar_height",
            "dimen",
            "android"
        )

        return if (resourceId > 0) {
            getDimensionPixelSize(resourceId)
        } else {
            DEFAULT_VIEW_SIZE
        }
    }

fun Context.dpToPx(
    dp: Number
): Number = dp.toFloat() * densityScale

fun Context.pxToDp(
    px: Number
): Number = px.toFloat() / densityScale