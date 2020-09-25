package com.lockwood.automata.screen

import android.app.Activity
import android.os.Build
import android.util.DisplayMetrics
import androidx.annotation.Px

@Suppress("DEPRECATION")
val Activity.displayMetrics: DisplayMetrics
    @Throws(IllegalArgumentException::class)
    get() {

        val displayMetrics = DisplayMetrics()

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
            windowManager.defaultDisplay.getMetrics(displayMetrics)
        } else {
            requireNotNull(display).getRealMetrics(displayMetrics)
        }

        return displayMetrics
    }

val Activity.screenWidth: Int
    @Px
    get() = displayMetrics.widthPixels

val Activity.screenHeight: Int
    @Px
    get() = displayMetrics.heightPixels
