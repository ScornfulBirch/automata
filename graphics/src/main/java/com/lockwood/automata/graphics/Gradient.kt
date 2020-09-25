package com.lockwood.automata.graphics

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.annotation.ColorInt
import androidx.annotation.Px

private const val DEFAULT_GRADIENT_COLOR = Color.TRANSPARENT
private const val DEFAULT_RADIUS_SIZE = 0.0F
private const val DEFAULT_STROKE_SIZE = DEFAULT_RADIUS_SIZE

fun buildGradientDrawable(
    colors: IntArray,
    gradientShape: Int = GradientDrawable.RECTANGLE,
    orientation: GradientDrawable.Orientation = GradientDrawable.Orientation.LEFT_RIGHT,
    @ColorInt strokeColor: Int = DEFAULT_GRADIENT_COLOR,
    @Px radius: Float = DEFAULT_RADIUS_SIZE,
    @Px stroke: Float = DEFAULT_STROKE_SIZE
): GradientDrawable = GradientDrawable(orientation, colors).apply {
    shape = gradientShape
    cornerRadius = radius
    setStroke(stroke.toInt(), strokeColor)
}