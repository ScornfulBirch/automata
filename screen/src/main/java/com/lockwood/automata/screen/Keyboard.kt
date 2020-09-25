package com.lockwood.automata.screen

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.lockwood.automata.android.getSystemService

private val Context.inputMethodManager: InputMethodManager
    get() = requireNotNull(getSystemService())

fun Fragment.hideKeyboard() {
    val view = requireNotNull(view).rootView
    requireNotNull(view) {
        return
    }

    view.hideKeyboard()
}

fun Activity.hideKeyboard() {
    val view = currentFocus
    requireNotNull(view) {
        return
    }

    view.hideKeyboard()
}

private fun View.hideKeyboard() {
    val inputMethodManager = context.inputMethodManager
    inputMethodManager.hideSoftInputFromWindow(windowToken, 0)

    clearFocus()
}