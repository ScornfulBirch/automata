package com.lockwood.automata.android

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.lockwood.automata.newInstance

inline fun <reified T : DialogFragment> Fragment.showDialog(
    tag: String
) = newInstance<T>().show(supportFragmentManager, tag)

inline fun <reified T : DialogFragment> AppCompatActivity.showDialog(
    tag: String
) = newInstance<T>().show(supportFragmentManager, tag)