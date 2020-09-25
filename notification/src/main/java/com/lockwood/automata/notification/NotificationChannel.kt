package com.lockwood.automata.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.lockwood.automata.android.getSystemService

private val Context.notificationManager: NotificationManager
    get() = requireNotNull(getSystemService())

@RequiresApi(Build.VERSION_CODES.O)
inline fun buildNotificationChannel(
    channelId: String,
    channelName: String,
    importance: Int = NotificationManager.IMPORTANCE_DEFAULT,
    onBuild: NotificationChannel .() -> Unit = {}
): NotificationChannel = NotificationChannel(channelId, channelName, importance).apply {
    onBuild()
}

fun NotificationCompat.Builder.withNotificationChannel(
    context: Context,
    notificationChannel: NotificationChannel
): NotificationCompat.Builder {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        context.notificationManager.createNotificationChannel(notificationChannel)
    }

    return this
}