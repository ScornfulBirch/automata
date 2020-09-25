package com.lockwood.automata.demo.fragment.animation

import android.os.Bundle
import android.view.View
import com.lockwood.automata.android.newFragment
import com.lockwood.automata.animation.slideDown
import com.lockwood.automata.animation.slideUp
import com.lockwood.automata.demo.R
import com.lockwood.automata.demo.fragment.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_slide_animation.*

class SlideAnimationFragment : BaseFragment(R.layout.fragment_slide_animation) {

    companion object {

        private const val DEFAULT_ANIMATION_DURATION = 500

        fun newInstance(): SlideAnimationFragment {
            return newFragment()
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        setupSlideUpAnimation()
        setupSlideDownAnimation()
    }

    private fun setupSlideUpAnimation() {
        with(animation_slide_up) {
            setOnClickListener {
                slideUp(duration = DEFAULT_ANIMATION_DURATION)
            }
        }
    }

    private fun setupSlideDownAnimation() {
        with(animation_slide_down) {
            setOnClickListener {
                slideDown(duration = DEFAULT_ANIMATION_DURATION)
            }
        }
    }

}