package com.lockwood.automata.animation

import android.app.Activity

private const val FADE_IN_ANIMATION = android.R.anim.fade_in
private const val FADE_OUT_ANIMATION = android.R.anim.fade_out

fun Activity.performFadeTransition() {
    overridePendingTransition(
        FADE_IN_ANIMATION,
        FADE_OUT_ANIMATION
    )
}