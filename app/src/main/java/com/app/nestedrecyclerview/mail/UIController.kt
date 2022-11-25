package com.app.nestedrecyclerview.mail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.airbnb.epoxy.EpoxyController
import com.app.nestedrecyclerview.mail.WLTab.ACCOUNT
import com.app.nestedrecyclerview.mail.WLTab.CREDIT
import com.app.nestedrecyclerview.mail.viewpager.WLPagerFragment
import com.app.nestedrecyclerview.mail.viewpager.viewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.Tab

class UIController(
    private val fragmentActivity: FragmentActivity
) : EpoxyController() {

    fun updateSelectedTab(position: Int) {
        lastSelectedTabPosition = position
        requestModelBuild()
    }

    private var lastSelectedTabPosition: Int = 0

    override fun buildModels() {
        val tabs: ArrayList<WLTab> = arrayListOf(
            ACCOUNT,
            CREDIT
        )

        List(20) {
            textItem {
                id("item_$it")
                title("Hello item $it")
            }
        }
        wLDetailsTabBar {
            id("tab_layout")
            tabs(tabs)
            selectedPosition(this@UIController.lastSelectedTabPosition)
            onTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: Tab?) {
                    this@UIController.lastSelectedTabPosition = tab?.position ?: 0
                    this@UIController.requestModelBuild()
                }

                override fun onTabUnselected(tab: Tab?) {
                }

                override fun onTabReselected(tab: Tab?) {
                }
            })
        }
        val fragments: ArrayList<Fragment> = arrayListOf(WLPagerFragment(), WLPagerFragment())
        viewPager {
            id("view_pager")
            fragments(fragments)
            fragmentActivity(this@UIController.fragmentActivity)
            selectedPosition(this@UIController.lastSelectedTabPosition)
            onPageChangeListener(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                }

                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                }

            })
        }
        List(20) {
            textItem {
                id("item_2_$it")
                title("Hello item $it")
            }
        }
    }
}