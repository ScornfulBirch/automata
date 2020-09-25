package com.lockwood.automata.intent

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.FileProvider
import com.lockwood.automata.android.buildIntent
import com.lockwood.automata.android.safeLaunchActivity
import com.lockwood.automata.android.safeLaunchActivityForResult
import java.io.File

@RequiresApi(Build.VERSION_CODES.KITKAT)
fun Activity.startCreateFile(
    fileName: String,
    fileType: String,
    requestCode: Int,
    onFailure: () -> Unit = {}
) {
    val intent = buildIntent(Intent.ACTION_CREATE_DOCUMENT) {
        type = fileType
        addCategory(Intent.CATEGORY_OPENABLE)
        putExtra(Intent.EXTRA_TITLE, fileName)
    }

    safeLaunchActivityForResult(
        intent = intent,
        requestCode = requestCode,
        onNoActivityToResolve = onFailure
    )
}

fun Context.openFile(
    file: File,
    fileType: String,
    onFailure: () -> Unit = {}
) {
    val uri = Uri.fromFile(file)

    openFile(uri, fileType, onFailure)
}

fun Context.openFileByProvider(
    file: File,
    fileType: String,
    onFailure: () -> Unit = {}
) {
    val authority = "${applicationContext.packageName}.provider"
    val uri = FileProvider.getUriForFile(this, authority, file)

    openFile(uri, fileType, onFailure)
}

fun Context.openFile(
    uri: Uri,
    fileType: String,
    onFailure: () -> Unit = {}
) {
    val intent = buildIntent(Intent.ACTION_VIEW) {
        setDataAndType(uri, fileType)
        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    }

    safeLaunchActivity(
        intent = intent,
        onNoActivityToResolve = onFailure
    )
}

