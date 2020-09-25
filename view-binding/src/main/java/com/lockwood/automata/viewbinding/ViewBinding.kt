package com.lockwood.automata.viewbinding

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

/**
 * Инфлейт ViewBinding заданного типа [T].
 *
 * Метод для вызова в [Activity.setContentView] с байндингом
 */
inline fun <reified T : ViewBinding> Activity.inflateView(): T {
    val binding: T = layoutInflater.inflateViewBinding()
    setContentView(binding.root)
    return binding
}

inline fun <reified T : ViewBinding> inflateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
): View = inflater.inflateViewBinding<T>(container, false).root

/**
 * Инфлейт ViewBinding заданного типа [T].
 *
 * В качестве родителя используется [ViewGroup], по умолчанию view прикрепляется к корню родителя.
 * **ВАЖНО!** Для инфлейта вьюх с `merge` в корне нужно использовать только этот метод.
 */
inline fun <reified T : ViewBinding> ViewGroup.inflateViewBinding(
    context: Context = this.context,
    attachToRoot: Boolean = true,
): T = T::class.inflate(LayoutInflater.from(context), this, attachToRoot)

/**
 * Инфлейт ViewBinding заданного типа [T].
 *
 * Метод для случая если нет [ViewGroup] или готового [LayoutInflater], в этом случае можно передать
 * контекст из которого будет получен [LayoutInflater].
 */
inline fun <reified T : ViewBinding> Context.inflateViewBinding(
    parent: ViewGroup? = null,
    attachToRoot: Boolean = parent != null,
): T = T::class.inflate(LayoutInflater.from(this), parent, attachToRoot)

/**
 * Инфлейт ViewBinding заданного типа [T], с использованием заданного [LayoutInflater].
 */
inline fun <reified T : ViewBinding> LayoutInflater.inflateViewBinding(
    parent: ViewGroup? = null,
    attachToRoot: Boolean = parent != null,
): T = T::class.inflate(this, parent, attachToRoot)
