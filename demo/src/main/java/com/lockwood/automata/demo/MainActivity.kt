package com.lockwood.automata.demo

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.lockwood.automata.android.addOnBackStackChangedListener
import com.lockwood.automata.android.transactAllowingStateLoss
import com.lockwood.automata.demo.databinding.ActivityMainBinding
import com.lockwood.automata.demo.fragment.MainFragment
import com.lockwood.automata.viewbinding.inflateView

class MainActivity : AppCompatActivity(), FragmentContainer {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inflateView<ActivityMainBinding>()

        if (savedInstanceState == null) {
            showMainFragment()
        }

        setupBackStackChangedListener()
    }

    override fun showFragment(fragment: Fragment, tag: String) {
        val fragmentPopped = supportFragmentManager.popBackStackImmediate(tag, 0)
        if (!fragmentPopped) {
            supportFragmentManager.transactAllowingStateLoss {
                replace(R.id.main_fragment_container, fragment, tag)
                addToBackStack(tag)
            }
        }
    }

    private fun showMainFragment() {
        val fragment = MainFragment.newInstance()
        showFragment(fragment, MainFragment.toString())
    }

    private fun setupBackStackChangedListener() {
        supportFragmentManager.addOnBackStackChangedListener { entryCount, _ ->
            requireNotNull(supportActionBar).setDisplayHomeAsUpEnabled(entryCount > 1)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                val fragment = supportFragmentManager.findFragmentById(R.id.main_fragment_container)
                if (fragment !is MainFragment) {
                    onBackPressed()
                } else {
                    finish()
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}