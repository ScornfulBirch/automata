package com.lockwood.automata.demo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.lockwood.automata.demo.R
import com.lockwood.automata.demo.adapter.holder.ButtonsViewHolder

class ButtonsAdapter(
    private val titles: Array<String>,
    private val listener: View.OnClickListener
) : BaseAdapter<ButtonsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_button, parent, false) as Button
        return ButtonsViewHolder(view, titles, listener)
    }

    override fun getItemCount(): Int {
        return titles.size
    }

}