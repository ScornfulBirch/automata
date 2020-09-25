package com.lockwood.automata

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

@ExperimentalContracts
fun <T> Collection<T>?.isNotNullOrEmpty(): Boolean {
    contract {
        returns() implies (this@isNotNullOrEmpty != null)
    }

    return !isNullOrEmpty()
}