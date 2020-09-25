package com.lockwood.automata.notification

import android.app.Notification
import android.content.Context
import android.graphics.Bitmap
import androidx.core.app.NotificationCompat
import com.lockwood.automata.text.ellipsizeEnd

private const val NOTIFICATION_MAX_LENGTH = 250

inline fun Context.buildNotification(
    channelId: String,
    onBuild: NotificationCompat.Builder.() -> NotificationCompat.Builder = { this }
): Notification = NotificationCompat.Builder(this, channelId)
    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
    .onBuild()
    .build()

fun NotificationCompat.Builder.setTextStyle(
    title: String,
    text: String
): NotificationCompat.Builder = with(this) {
    setContentTitle(title)
    setContentText(text)
}

fun NotificationCompat.Builder.setBigTextStyle(
    title: String,
    smallText: String,
    bigText: String
): NotificationCompat.Builder = with(this) {
    setTextStyle(title, smallText)
    val ellipsizedText = bigText.ellipsizeEnd(NOTIFICATION_MAX_LENGTH)

    setStyle(
        NotificationCompat.BigTextStyle().bigText(ellipsizedText)
    )
}

fun NotificationCompat.Builder.setBigPictureStyle(
    bigPicture: Bitmap,
    largeIcon: Bitmap? = null
): NotificationCompat.Builder = with(this) {
    setStyle(
        NotificationCompat.BigPictureStyle().bigPicture(bigPicture).bigLargeIcon(null)
    )
    setLargeIcon(largeIcon)
}