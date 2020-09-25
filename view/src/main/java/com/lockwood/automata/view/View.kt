package com.lockwood.automata.view

import android.app.Activity
import android.content.res.ColorStateList
import android.graphics.Rect
import android.os.Build
import android.view.View
import android.view.ViewTreeObserver
import androidx.annotation.ColorInt
import com.lockwood.automata.screen.screenHeight
import com.lockwood.automata.screen.screenWidth

val View.isVisibleOnScreen: Boolean
    get() {
        if (!isShown) {
            return false
        }

        val actualPosition = Rect()
        getGlobalVisibleRect(actualPosition)

        val activity = (context as Activity)

        val screen = Rect(0, 0, activity.screenWidth, activity.screenHeight)
        return actualPosition.intersect(screen)
    }

fun View.updateBackgroundColor(
    @ColorInt backgroundColor: Int
) = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
    backgroundTintList = ColorStateList.valueOf(backgroundColor)
} else {
    setBackgroundColor(backgroundColor)
}

inline fun <T : View> T.afterMeasured(
    crossinline f: T.() -> Unit
) = viewTreeObserver.addOnGlobalLayoutListener {
    if (measuredWidth > 0 && measuredHeight > 0) {
        f()
    }
}

inline fun <T : View> T.afterMeasuredOnce(
    crossinline f: T.() -> Unit
) = viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
    override fun onGlobalLayout() {
        if (measuredWidth > 0 && measuredHeight > 0) {
            viewTreeObserver.removeOnGlobalLayoutListener(this)
            f()
        }
    }
})