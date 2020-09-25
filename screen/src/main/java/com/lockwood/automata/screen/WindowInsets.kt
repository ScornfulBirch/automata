package com.lockwood.automata.screen

import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

inline fun View.doOnApplyWindowInsets(
    crossinline f: View.(WindowInsetsCompat) -> Unit
) {
    ViewCompat.setOnApplyWindowInsetsListener(this) { _, insets ->
        f(insets)
        insets
    }
}