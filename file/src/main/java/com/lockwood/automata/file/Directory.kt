package com.lockwood.automata.file

import java.io.File

fun File.deleteDirectory(): Boolean {
    return when {
        isDirectory -> {
            val children = list()
            children?.forEach {
                val success = File(this, it).deleteDirectory()
                if (!success) {
                    return false
                }
            }
            delete()
        }
        isFile -> {
            delete()
        }
        else -> {
            false
        }
    }
}