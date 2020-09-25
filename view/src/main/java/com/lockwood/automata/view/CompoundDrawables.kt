package com.lockwood.automata.view

import android.graphics.drawable.Drawable
import android.os.Build
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import com.lockwood.automata.android.isRightToLeft

fun TextView.updateCompoundDrawables(
    start: Drawable? = null,
    top: Drawable? = null,
    end: Drawable? = null,
    bottom: Drawable? = null
) = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
    setCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom)
} else {
    setCompoundDrawablesWithIntrinsicBounds(start, top, end, bottom)
}

inline fun TextView.setOnTopDrawableClickListener(
    crossinline action: TextView.() -> Unit
) = setOnCompoundDrawableClickListener(
    drawableClicked = { view, event ->
        val topDrawableOffset = view.height - (view as TextView).totalPaddingTop
        return@setOnCompoundDrawableClickListener event.y <= topDrawableOffset
    },
    action = {
        action()
    }
)

inline fun TextView.setOnBottomDrawableClickListener(
    crossinline action: TextView.() -> Unit
) = setOnCompoundDrawableClickListener(
    drawableClicked = { view, event ->
        val bottomDrawableOffset = view.height - (view as TextView).totalPaddingBottom
        return@setOnCompoundDrawableClickListener event.y >= bottomDrawableOffset
    },
    action = {
        action()
    }
)

inline fun TextView.setOnStartDrawableClickListener(
    crossinline action: TextView.() -> Unit
) = if (context.isRightToLeft) {
    setOnCompoundDrawableClickListener(
        drawableClicked = { view, event ->
            val rightDrawableOffset = view.width - (view as TextView).totalPaddingRight
            return@setOnCompoundDrawableClickListener event.x >= rightDrawableOffset
        },
        action = {
            action()
        }
    )
} else {
    setOnCompoundDrawableClickListener(
        drawableClicked = { view, event ->
            val leftDrawableOffset = view.width - (view as TextView).totalPaddingLeft
            return@setOnCompoundDrawableClickListener event.x <= leftDrawableOffset
        },
        action = {
            action()
        }
    )
}

inline fun TextView.setOnEndDrawableClickListener(
    crossinline action: TextView.() -> Unit
) = if (context.isRightToLeft) {
    setOnCompoundDrawableClickListener(
        drawableClicked = { view, event ->
            val leftDrawableOffset = view.width - (view as TextView).totalPaddingLeft
            return@setOnCompoundDrawableClickListener event.x <= leftDrawableOffset
        },
        action = {
            action()
        }
    )
} else {
    setOnCompoundDrawableClickListener(
        drawableClicked = { view, event ->
            val rightDrawableOffset = view.width - (view as TextView).totalPaddingRight
            return@setOnCompoundDrawableClickListener event.x >= rightDrawableOffset
        },
        action = {
            action()
        }
    )
}

inline fun TextView.setOnCompoundDrawableClickListener(
    crossinline drawableClicked: (View, MotionEvent) -> Boolean,
    crossinline action: TextView.() -> Unit
) = setOnTouchListener { view, event ->
    val isDrawableClicked = drawableClicked(view, event)

    if (isDrawableClicked) {
        if (event.action == MotionEvent.ACTION_UP) {
            action()
        }

        view.performClick()
        return@setOnTouchListener true
    }

    return@setOnTouchListener false
}