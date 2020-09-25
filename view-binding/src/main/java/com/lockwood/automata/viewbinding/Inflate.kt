package com.lockwood.automata.viewbinding

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import java.lang.reflect.Method
import kotlin.reflect.KClass

private const val TAG = "Inflate"

/**
 * Динамический вызов метода inflate у ViewBinding.
 *
 * При помощи этого метода можно вызвать inflate у любого ViewBinding, что делает возможным
 * упрощение этого вызова.
 * @see inflateViewBinding
 */
@Suppress("UNCHECKED_CAST")
fun <T : ViewBinding> KClass<T>.inflate(
    inflater: LayoutInflater,
    parent: ViewGroup?,
    attachToRoot: Boolean,
): T {
    val inflateMethod = java.getInflateMethod()
    return if (inflateMethod.parameterTypes.size > 2) {
        inflateMethod.invoke(null, inflater, parent, attachToRoot)
    } else {
        if (!attachToRoot) {
            Log.d(TAG, "attachToRoot is always true for ${java.simpleName}.inflate")
        }
        inflateMethod.invoke(null, inflater, parent)
    } as T
}

/**
 * Получение биндинга заданного типа [T] из [View].
 */
inline fun <reified T : ViewBinding> View.getBinding(): T = T::class.bind(this)

internal val inflateMethodsCache = mutableMapOf<Class<out ViewBinding>, Method>()

internal fun Class<out ViewBinding>.getInflateMethod(): Method {
    return inflateMethodsCache.getOrPut(this) {
        declaredMethods.find { method ->
            val parameterTypes = method.parameterTypes
            method.name == "inflate" &&
                    parameterTypes[0] == LayoutInflater::class.java &&
                    parameterTypes.getOrNull(1) == ViewGroup::class.java &&
                    (parameterTypes.size == 2 || parameterTypes[2] == Boolean::class.javaPrimitiveType)
        }
            ?: error("Method ${this.simpleName}.inflate(LayoutInflater, ViewGroup[, boolean]) not found.")
    }
}

