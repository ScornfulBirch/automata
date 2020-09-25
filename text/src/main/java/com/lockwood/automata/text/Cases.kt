package com.lockwood.automata.text

import androidx.annotation.StringRes
import kotlin.math.abs

fun Int.countToCaption(
    @StringRes zeroRes: Int,
    @StringRes oneRes: Int,
    @StringRes moreRes: Int,
    @StringRes manyRes: Int
): Int = when (abs(this)) {
    0 -> zeroRes
    1 -> oneRes
    in 2..4 -> moreRes
    else -> manyRes
}

fun Int.countToCaption(
    zeroString: String,
    oneString: String,
    moreString: String,
    manyString: String
): String = when (this) {
    0 -> zeroString
    1 -> oneString
    in 2..4 -> moreString
    else -> manyString
}