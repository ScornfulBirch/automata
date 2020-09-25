package com.lockwood.automata

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

@ExperimentalContracts
fun CharSequence?.isNotNullOrEmpty(): Boolean {
    contract {
        returns() implies (this@isNotNullOrEmpty != null)
    }

    return !isNullOrEmpty()
}