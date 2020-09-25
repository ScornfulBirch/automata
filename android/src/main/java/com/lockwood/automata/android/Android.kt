package com.lockwood.automata.android

import android.content.Context
import android.content.res.Resources

val Resources.isTablet: Boolean
    get() = getBoolean(R.bool.is_tablet)

val Context.isTablet: Boolean
    get() = resources.getBoolean(R.bool.is_tablet)

val Resources.isRightToLeft: Boolean
    get() = getBoolean(R.bool.is_right_to_left)

val Context.isRightToLeft: Boolean
    get() = resources.getBoolean(R.bool.is_right_to_left)