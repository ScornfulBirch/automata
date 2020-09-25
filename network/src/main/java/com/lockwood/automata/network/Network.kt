package com.lockwood.automata.network

import android.Manifest.permission.ACCESS_NETWORK_STATE
import android.content.Context
import android.net.ConnectivityManager
import androidx.annotation.RequiresPermission
import com.lockwood.automata.android.getSystemService

private val Context.connectivityManager: ConnectivityManager
    get() = requireNotNull(getSystemService())

@Suppress("deprecation")
val Context.isOnline: Boolean
    @RequiresPermission(ACCESS_NETWORK_STATE)
    get() {
        val connectivityManager = connectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo

        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

