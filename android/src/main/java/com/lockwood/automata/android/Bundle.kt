package com.lockwood.automata.android

import android.os.Bundle

inline fun Bundle?.getIntOrDefault(
    key: String,
    default: () -> Int
): Int {
    checkNotNull(this) {
        return default()
    }

    return getInt(key, default())
}