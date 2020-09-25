package com.lockwood.automata.graphics

import androidx.annotation.ColorInt
import androidx.core.graphics.ColorUtils

private const val DEFAULT_LIGHTNESS_AMOUNT = 10

fun @receiver:ColorInt Int.makeBrighter(
    lightnessAmount: Int = DEFAULT_LIGHTNESS_AMOUNT
): Int {
    val hsl = floatArrayOf(0f, 0f, 0f)
    ColorUtils.colorToHSL(this, hsl)

    var lightness = hsl[2] + lightnessAmount / 255f

    if (lightness < 0f) {
        lightness = 0f
    } else if (lightness > 1f) {
        lightness = 1f
    }

    hsl[2] = lightness

    return ColorUtils.HSLToColor(hsl)
}