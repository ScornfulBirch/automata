package com.lockwood.automata.view

import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.annotation.LayoutRes

const val DEFAULT_ADAPTER_THRESHOLD = 1

inline fun AutoCompleteTextView.setStringAdapter(
    data: List<String>,
    textThreshold: Int = DEFAULT_ADAPTER_THRESHOLD,
    @LayoutRes dropdownItem: Int = DEFAULT_SPINNER_ITEM_LAYOUT,
    crossinline onItemSelected: AutoCompleteTextView.(AdapterView<*>, Int, Long) -> Unit = { _, _, _ -> dismissDropDown() }
) {
    ArrayAdapter(context, dropdownItem, data).also { adapter ->
        threshold = textThreshold
        setAdapter(adapter)
    }

    setItemSelectedListener(onItemSelected)
}

inline fun AutoCompleteTextView.setItemSelectedListener(
    crossinline onItemSelected: AutoCompleteTextView.(AdapterView<*>, Int, Long) -> Unit = { _, _, _ -> dismissDropDown() }
) = setOnItemClickListener { parent, _, position, id ->
    onItemSelected(parent, position, id)
}