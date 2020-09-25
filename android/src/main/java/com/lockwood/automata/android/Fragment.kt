package com.lockwood.automata.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.lockwood.automata.newInstance

inline fun <reified T : Fragment> newFragment(
    noinline init: Bundle.() -> Unit = {}
): T {
    val fragment = newInstance<T>()

    val args = Bundle()
    args.init()
    fragment.arguments = args

    return fragment
}