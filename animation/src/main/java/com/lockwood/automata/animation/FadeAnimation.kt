package com.lockwood.automata.animation

import android.view.View

fun View.fadeOut(
    duration: Long = FADE_DURATION
) = animate {
    alpha(FADE_VISIBILITY_INVISIBLE)
    setDuration(duration)
    withEndAction {
        visibility = View.INVISIBLE
    }
}

fun View.fadeIn(
    duration: Long = FADE_DURATION
) {
    visibility = View.VISIBLE
    alpha = FADE_VISIBILITY_INVISIBLE

    animate {
        alpha(FADE_VISIBILITY_VISIBLE)
        setDuration(duration)
    }
}

fun View.visibilityFade(
    isVisible: Boolean = false
) {
    if (isVisible) {
        fadeIn(FADE_VISIBILITY_DURATION)
    } else {
        fadeOut(FADE_VISIBILITY_DURATION)
    }
}

