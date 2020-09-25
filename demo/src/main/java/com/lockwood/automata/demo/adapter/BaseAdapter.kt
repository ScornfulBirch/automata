package com.lockwood.automata.demo.adapter

import androidx.recyclerview.widget.RecyclerView
import com.lockwood.automata.demo.adapter.holder.BaseViewHolder

abstract class BaseAdapter<T : BaseViewHolder<*>> : RecyclerView.Adapter<T>() {

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.onBind(position)
    }

}