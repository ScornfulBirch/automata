package com.lockwood.automata

inline fun <reified T : Any> newInstance(): T = T::class.java.newInstance()