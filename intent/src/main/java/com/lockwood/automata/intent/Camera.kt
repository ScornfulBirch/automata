package com.lockwood.automata.intent

import android.app.Activity
import android.net.Uri
import android.provider.MediaStore
import com.lockwood.automata.android.buildIntent
import com.lockwood.automata.android.safeLaunchActivityForResult

fun Activity.capturePhoto(
    uri: Uri,
    requestCode: Int,
    onFailure: () -> Unit = {}
) = startCameraAction(
    uri = uri,
    requestCode = requestCode,
    action = MediaStore.ACTION_IMAGE_CAPTURE,
    onFailure = onFailure
)

fun Activity.captureStillImage(
    uri: Uri,
    requestCode: Int,
    onFailure: () -> Unit = {}
) = startCameraAction(
    uri = uri,
    requestCode = requestCode,
    action = MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA,
    onFailure = onFailure
)

fun Activity.captureVideo(
    uri: Uri,
    requestCode: Int,
    onFailure: () -> Unit = {}
) = startCameraAction(
    uri = uri,
    requestCode = requestCode,
    action = MediaStore.INTENT_ACTION_VIDEO_CAMERA,
    onFailure = onFailure
)

private fun Activity.startCameraAction(
    uri: Uri,
    action: String,
    requestCode: Int,
    onFailure: () -> Unit = {}
) {
    val intent = buildIntent(action) {
        putExtra(MediaStore.EXTRA_OUTPUT, uri)
    }

    safeLaunchActivityForResult(
        intent = intent,
        requestCode = requestCode,
        onNoActivityToResolve = onFailure
    )
}