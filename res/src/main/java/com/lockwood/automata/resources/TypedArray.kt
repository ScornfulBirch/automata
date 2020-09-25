package com.lockwood.automata.resources

import android.content.res.TypedArray
import androidx.annotation.ColorInt
import androidx.annotation.Px
import androidx.annotation.StyleableRes
import com.lockwood.automata.EMPTY

@ColorInt
inline fun TypedArray.getColorOrDefault(
    @StyleableRes index: Int,
    default: () -> Int
): Int = getColor(index, default())

@Px
inline fun TypedArray.getTextSizeOrDefault(
    @StyleableRes index: Int,
    default: () -> Int
): Int = getDimensionPixelSize(index, default())

@Px
inline fun TypedArray.getTextColorOrDefault(
    @StyleableRes index: Int,
    default: () -> Int
): Int = getColor(index, default())

inline fun TypedArray.getStringOrDefault(
    @StyleableRes index: Int,
    default: () -> String = { String.EMPTY }
): String = getString(index) ?: default()