package com.lockwood.automata.file

import android.content.ContentResolver
import android.net.Uri
import java.io.FileDescriptor

const val FILE_MODE_WRITE = "w"
const val FILE_MODE_READ = "r"

inline fun ContentResolver.openFileDescriptor(
    uri: Uri,
    mode: String,
    action: FileDescriptor.() -> Unit
) {
    val parcelFileDescriptor = requireNotNull(openFileDescriptor(uri, mode))
    val fileDescriptor = requireNotNull(parcelFileDescriptor.fileDescriptor)

    fileDescriptor.action()

    parcelFileDescriptor.close()
}

inline fun ContentResolver.openWriteFileDescriptor(
    uri: Uri,
    action: FileDescriptor.() -> Unit
) = openFileDescriptor(
    uri = uri,
    mode = FILE_MODE_WRITE,
    action = action
)

inline fun ContentResolver.openReadFileDescriptor(
    uri: Uri,
    action: FileDescriptor.() -> Unit
) = openFileDescriptor(
    uri = uri,
    mode = FILE_MODE_READ,
    action = action
)
