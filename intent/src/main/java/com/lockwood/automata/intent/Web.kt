package com.lockwood.automata.intent

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import com.lockwood.automata.android.buildIntent
import com.lockwood.automata.android.safeLaunchActivity

fun Context.openWebPage(
    url: String,
    onFailure: () -> Unit = {}
) {
    val webPage: Uri = Uri.parse(url)

    val intent = buildIntent(Intent.ACTION_VIEW, webPage)

    safeLaunchActivity(
        intent = intent,
        onNoActivityToResolve = onFailure
    )
}

fun Context.searchWeb(
    query: String,
    onFailure: () -> Unit = {}
) {
    val intent = buildIntent(Intent.ACTION_WEB_SEARCH) {
        putExtra(SearchManager.QUERY, query)
    }

    safeLaunchActivity(
        intent = intent,
        onNoActivityToResolve = onFailure
    )
}
