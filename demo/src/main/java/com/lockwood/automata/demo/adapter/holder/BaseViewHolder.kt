package com.lockwood.automata.demo.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T : View>(
    protected val view: T
) : RecyclerView.ViewHolder(view) {

    abstract fun onBind(position: Int)

}