package com.lockwood.automata.demo.fragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.lockwood.automata.android.newFragment
import com.lockwood.automata.demo.adapter.ButtonsAdapter
import com.lockwood.automata.demo.fragment.animation.AnimationFragment
import com.lockwood.automata.demo.fragment.base.BaseRecyclerFragment
import com.lockwood.automata.view.toast
import kotlinx.android.synthetic.main.fragment_recycler.*

class MainFragment : BaseRecyclerFragment(), View.OnClickListener {

    companion object {

        private val TAG = MainFragment::class.simpleName

        private val BUTTONS_TITLES = arrayOf(
            "Android",
            "Animation",
            "Delegate",
            "File",
            "Graphics",
            "Intent",
            "Network",
            "Notifications",
            "Resources",
            "Screen",
            "Text",
            "Time",
            "View",
            "Other"
        )

        fun newInstance(): MainFragment {
            return newFragment()
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(main_recycler_view) {
            adapter = ButtonsAdapter(BUTTONS_TITLES, this@MainFragment)
        }
    }

    override fun onClick(view: View) {
        val buttonView = view as Button

        when (val buttonText = buttonView.text.toString()) {
            BUTTONS_TITLES[1] -> {
                val fragment = AnimationFragment.newInstance()
                showFragment(fragment)
            }
            else -> {
                requireContext().toast(buttonText)
            }
        }
    }


    private fun showFragment(fragment: Fragment) {
        showFragment(fragment, requireNotNull(TAG))
    }

}