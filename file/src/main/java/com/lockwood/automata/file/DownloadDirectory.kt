package com.lockwood.automata.file

import android.content.Context
import android.os.Build
import android.os.Environment
import java.io.File
import java.io.IOException

@Throws(IOException::class)
@Suppress("DEPRECATION")
fun Context.getExternalDirectory(
    type: String? = null,
    useLegacyStorage: Boolean = false
): File {
    return if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q || useLegacyStorage) {
        Environment.getExternalStoragePublicDirectory(type)
    } else {
        getExternalFilesDir(type) ?: throw IOException("External storage is not currently mounted")
    }
}

@Throws(IOException::class)
@Suppress("DEPRECATION")
fun Context.getDownloadsExternalDirectory(
    useLegacyStorage: Boolean = false
): File = getExternalDirectory(Environment.DIRECTORY_DOWNLOADS, useLegacyStorage)