package com.lockwood.automata.demo.fragment.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.lockwood.automata.demo.FragmentContainer

abstract class BaseFragment(
    @LayoutRes contentLayoutId: Int
) : Fragment(contentLayoutId), FragmentContainer {

    override fun showFragment(fragment: Fragment, tag: String) {
        (requireActivity() as FragmentContainer).showFragment(fragment, tag)
    }

}