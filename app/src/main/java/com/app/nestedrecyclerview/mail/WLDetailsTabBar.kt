package com.app.nestedrecyclerview.mail

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import com.app.nestedrecyclerview.R
import com.app.nestedrecyclerview.databinding.CustomeTabLayoutBinding
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

val ViewGroup.layoutInflater: LayoutInflater get() = LayoutInflater.from(this.context)

enum class WLTab(var title: String) {
    ACCOUNT("account"),
    CREDIT("credit")
}

class WLDetailsTabBar @JvmOverloads constructor(

    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var lastTabs: ArrayList<WLTab> = arrayListOf()

    private val binding: CustomeTabLayoutBinding by lazy {
        CustomeTabLayoutBinding.inflate(layoutInflater, this, false)
    }

    init {
        if(!isInEditMode) {
            addView(binding.root)
        }
    }

    fun bind(tabs: ArrayList<WLTab>, selectedPosition: Int, onTabSelectedListener: OnTabSelectedListener) {
        if (lastTabs != tabs) {
            setNewTabs(tabs)
        }

        // We don't set the position if it is the same, since the layout will reanimate back to that position
        if (selectedPosition != binding.tabLayout.selectedTabPosition) {
            binding.tabLayout.getTabAt(selectedPosition)?.select()
        }

        // Add the listener after selecting the tab so the listener isn't called
        binding.tabLayout.addOnTabSelectedListener(onTabSelectedListener)

        lastTabs.addAll(tabs)
    }

    private fun setNewTabs(tabs: List<WLTab>) {
        binding.tabLayout.removeAllTabs()
        for (tab in tabs) {
            binding.tabLayout.addTab(
                binding.tabLayout.newTab()
                    .setText(tab.title)
            )
        }
    }
}