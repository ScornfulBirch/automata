package com.lockwood.automata.file

import android.util.Base64

fun String.decodeBase64(
    flags: Int = Base64.DEFAULT
): ByteArray = Base64.decode(this, flags)

fun ByteArray.encodeBase64(
    flags: Int = Base64.DEFAULT
): String = Base64.encodeToString(this, flags)