package com.lockwood.automata.demo.adapter.holder

import android.view.View
import android.widget.Button

class ButtonsViewHolder(
    view: Button,
    private val titles: Array<String>,
    private val listener: View.OnClickListener
) : BaseViewHolder<Button>(view) {

    override fun onBind(position: Int) {
        val title = titles[position]

        with(view) {
            text = title
            setOnClickListener(listener)
        }
    }

}