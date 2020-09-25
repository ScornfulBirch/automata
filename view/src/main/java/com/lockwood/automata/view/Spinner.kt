package com.lockwood.automata.view

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.annotation.LayoutRes

const val DEFAULT_SPINNER_ITEM_LAYOUT = android.R.layout.simple_spinner_dropdown_item

inline fun Spinner.setStringAdapter(
    data: List<String>,
    @LayoutRes dropdownItem: Int = DEFAULT_SPINNER_ITEM_LAYOUT,
    crossinline onItemSelected: Spinner.(AdapterView<*>, Int, Long) -> Unit = { _, _, _ -> }
) {
    ArrayAdapter(context, dropdownItem, data).also { adapter ->
        setAdapter(adapter)
    }

    setItemSelectedListener(onItemSelected)
}

inline fun Spinner.setItemSelectedListener(
    crossinline onItemSelected: Spinner.(AdapterView<*>, Int, Long) -> Unit = { _, _, _ -> }
) {
    onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

        override fun onItemSelected(
            parent: AdapterView<*>,
            view: View?,
            position: Int,
            id: Long
        ) {
            onItemSelected(parent, position, id)
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {}

    }
}