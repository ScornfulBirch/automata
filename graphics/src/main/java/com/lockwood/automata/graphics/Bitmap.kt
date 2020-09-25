package com.lockwood.automata.graphics

import android.graphics.Bitmap
import java.util.*

fun Bitmap.cropTransparent(): Bitmap {
    var empty = IntArray(width)
    var buffer = IntArray(width)
    Arrays.fill(empty, 0)

    var top = 0
    var left = 0
    var bottom = height
    var right = width

    for (y in 0 until height) {
        getPixels(buffer, 0, width, 0, y, width, 1)
        if (!empty.contentEquals(buffer)) {
            top = y
            break
        }
    }

    for (y in height - 1 downTo top + 1) {
        getPixels(buffer, 0, width, 0, y, width, 1)
        if (!empty.contentEquals(buffer)) {
            bottom = y
            break
        }
    }

    val bufferSize = bottom - top + 1
    empty = IntArray(bufferSize)
    buffer = IntArray(bufferSize)
    Arrays.fill(empty, 0)

    for (x in 0 until width) {
        getPixels(buffer, 0, 1, x, top + 1, 1, bufferSize)
        if (!empty.contentEquals(buffer)) {
            left = x
            break
        }
    }

    Arrays.fill(empty, 0)
    for (x in width - 1 downTo left + 1) {
        getPixels(buffer, 0, 1, x, top + 1, 1, bufferSize)
        if (!empty.contentEquals(buffer)) {
            right = x
            break
        }
    }

    return Bitmap.createBitmap(
        this,
        left,
        top,
        right - left,
        bottom - top
    )
}