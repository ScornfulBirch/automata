package com.lockwood.automata

val Int.isOdd: Boolean
    get() = this and 0x01 != 0

val Int.isEven: Boolean
    get() = !isOdd