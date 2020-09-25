package com.lockwood.automata.demo.fragment.animation

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.lockwood.automata.android.newFragment
import com.lockwood.automata.demo.adapter.ButtonsAdapter
import com.lockwood.automata.demo.fragment.base.BaseRecyclerFragment
import com.lockwood.automata.view.toast
import kotlinx.android.synthetic.main.fragment_recycler.*

class AnimationFragment : BaseRecyclerFragment(), View.OnClickListener {

    companion object {

        private val TAG = SlideAnimationFragment::class.simpleName

        private val BUTTONS_TITLES = arrayOf(
            "Slide Animation"
        )

        fun newInstance(): AnimationFragment {
            return newFragment()
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(main_recycler_view) {
            adapter = ButtonsAdapter(BUTTONS_TITLES, this@AnimationFragment)
        }

    }

    override fun onClick(view: View) {
        val buttonView = view as Button

        when (val text = buttonView.text.toString()) {
            BUTTONS_TITLES[0] -> {
                val fragment = SlideAnimationFragment.newInstance()
                showFragment(fragment)
            }
            else -> {
                requireContext().toast(text)
            }
        }

    }

    private fun showFragment(fragment: Fragment) {
        showFragment(fragment, requireNotNull(TAG))
    }

}