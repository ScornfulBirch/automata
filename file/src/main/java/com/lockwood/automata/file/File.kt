package com.lockwood.automata.file

import android.webkit.MimeTypeMap
import java.io.File

private const val ANY_MIME_TYPE = "*/*"

val File.notExist: Boolean
    get() = !exists()

val File.extension: String
    get() = name.substringAfterLast(".")

val File.mimeType: String
    get() = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension) ?: ANY_MIME_TYPE