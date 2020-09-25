package com.lockwood.automata.file

import java.io.FileOutputStream

fun FileOutputStream.writeData(
    base64: String
) {
    val pdfByteArray = base64.decodeBase64()
    write(pdfByteArray)
    close()
}