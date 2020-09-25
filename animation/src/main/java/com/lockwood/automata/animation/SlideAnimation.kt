package com.lockwood.automata.animation

import android.view.View

fun View.slide(
    translationY: Number,
    duration: Number = TRANSLATE_DURATION
) {
    val translation = translationY.toFloat()
    val translateDuration = duration.toLong()

    startAnimation {
        animate {
            translationY(translation).duration = translateDuration
        }
    }
}

fun View.slideUp(
    distance: Number = height,
    duration: Number = TRANSLATE_DURATION
) {
    val resultTranslationY = translationY - distance.toFloat()

    slide(resultTranslationY, duration)
}

fun View.slideDown(
    distance: Number = height,
    duration: Number = TRANSLATE_DURATION
) {
    val resultTranslationY = translationY + distance.toFloat()

    slide(resultTranslationY, duration)
}