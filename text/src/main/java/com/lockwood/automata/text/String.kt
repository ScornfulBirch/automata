package com.lockwood.automata.text

private const val ELLIPSIZE_END_LIMIT = 3
private const val ELLIPSIZE_END_REPLACEMENT = "..."

fun String.safePlus(
    stringToAdd: String
): String {
    if (isNotEmpty() && !endsWith(stringToAdd)) {
        return plus(stringToAdd)
    }

    return this
}

fun String.ellipsizeEnd(
    maxLength: Int
): String {
    if (length > ELLIPSIZE_END_LIMIT && length >= maxLength) {

        val oldText = removeRange(maxLength, length)
        with(oldText) {
            val start = length - 1
            val end = length
            return replaceRange(
                start, end,
                ELLIPSIZE_END_REPLACEMENT
            )
        }
    }

    return this
}

fun String.toUpperCaseFirstLetter(): String = if (isNotEmpty()) {
    val firstChar = first().toUpperCase().toString()
    replaceRange(0, 1, firstChar)
} else {
    this
}