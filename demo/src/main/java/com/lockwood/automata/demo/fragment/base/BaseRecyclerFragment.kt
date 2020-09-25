package com.lockwood.automata.demo.fragment.base

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.recyclerview.widget.LinearLayoutManager
import com.lockwood.automata.demo.FragmentContainer
import com.lockwood.automata.demo.R
import kotlinx.android.synthetic.main.fragment_recycler.*

abstract class BaseRecyclerFragment : BaseFragment(R.layout.fragment_recycler),
    FragmentContainer {

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        with(main_recycler_view) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }

}