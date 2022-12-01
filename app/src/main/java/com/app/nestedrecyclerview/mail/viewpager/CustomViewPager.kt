package com.app.nestedrecyclerview.mail.viewpager

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.app.nestedrecyclerview.databinding.CustomViewPagerBinding
import com.app.nestedrecyclerview.mail.layoutInflater

class CustomViewPager @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(
    context, attrs, defStyleAttr
) {

    private var localFragment: ArrayList<Fragment> = arrayListOf()

    private val binding: CustomViewPagerBinding by lazy {
        CustomViewPagerBinding.inflate(layoutInflater, this, false)
    }

    init {
        if (!isInEditMode) {
            addView(binding.root)
        }
    }

    fun binding(
        fragments: ArrayList<Fragment>,
        selectionPosition: Int,
        fragmentActivity: FragmentActivity,
        onPageChangeListener: ViewPager2.OnPageChangeCallback
    ) {
        println("binding ${selectionPosition}")
        if (localFragment != fragments) {
            localFragment.addAll(fragments)
            setUp(fragmentActivity)
        }
        if (selectionPosition != binding.viewPager2.currentItem) {
            binding.viewPager2.setCurrentItem(selectionPosition, true)
        }
    }

    private fun setUp(fragmentActivity: FragmentActivity) {
        val viewPagerAdapter = WLViewPagerAdapter(fragments = localFragment, fa = fragmentActivity)
        binding.viewPager2.adapter = viewPagerAdapter
    }
}