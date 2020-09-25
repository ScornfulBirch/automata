package com.lockwood.automata.android

import android.content.Context
import androidx.core.content.ContextCompat

inline fun <reified T> Context.getSystemService(): T? {
    return ContextCompat.getSystemService(this, T::class.java)
}