package com.lockwood.automata.notification

import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import com.lockwood.automata.android.getSystemService

private val Context.notificationManager: NotificationManager
    get() = requireNotNull(getSystemService())

fun Context.showNotification(
    id: Int,
    notification: Notification
) = notificationManager.notify(id, notification)

fun Context.cancelNotification(
    id: Int
) = notificationManager.cancel(id)

fun Context.cancelNotifications() {
    notificationManager.cancelAll()
}