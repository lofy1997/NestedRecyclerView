package com.app.nestedrecyclerview.mail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.carousel
import com.airbnb.epoxy.group
import com.airbnb.epoxy.stickyheader.StickyHeaderCallbacks
import com.app.nestedrecyclerview.R
import com.app.nestedrecyclerview.mail.WLTab.ACCOUNT
import com.app.nestedrecyclerview.mail.WLTab.CREDIT
import com.app.nestedrecyclerview.mail.header.CarouselItemModel_
import com.app.nestedrecyclerview.mail.viewpager.WLPagerFragment
import com.app.nestedrecyclerview.mail.viewpager.viewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.Tab

class UIController(
    private val fragmentActivity: FragmentActivity,
    private val onTabSelectedListener: (Int) -> Unit,
) : EpoxyController(), StickyHeaderCallbacks {


    fun updateSelectedTab(position: Int) {
        lastSelectedTabPosition = position
        requestModelBuild()
    }

    fun refresh() {
        requestModelBuild()
    }
    private var lastSelectedTabPosition: Int = 0
    private val fragments: ArrayList<Fragment> = arrayListOf(WLPagerFragment(), WLPagerFragment())
    override fun isStickyHeader(position: Int): Boolean  = adapter.getModelAtPosition(position) is WLDetailsTabBarModel

    override fun buildModels() {
        val tabs: ArrayList<WLTab> = arrayListOf(
            ACCOUNT,
            CREDIT
        )

        val carouselItems: ArrayList<CarouselItemModel_> = arrayListOf()

        List(10) {
            carouselItems.add(CarouselItemModel_().id("carousel_$it").title("Carousel title $it"))
        }
        group {
            id("carousel_group")
            layout(R.layout.component_horizontal_group)
            carousel {
                id("carousel_header")
                models(carouselItems)
                paddingDp(4)
                numViewsToShowOnScreen(1f)
                hasFixedSize(true)
            }
        }
        wLDetailsTabBar {
            id("tab_layout")
            tabs(tabs)
            selectedPosition(this@UIController.lastSelectedTabPosition)
            onTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: Tab?) {
                    this@UIController.refresh()
                    println("tab ${tab?.position}")
                    this@UIController.lastSelectedTabPosition = tab?.position ?: 0
                    this@UIController.onTabSelectedListener.invoke(tab?.position ?: 0)
                }

                override fun onTabUnselected(tab: Tab?) {
                }

                override fun onTabReselected(tab: Tab?) {
                }
            })
        }

        viewPager {
            id("view_pager")
            fragments(this@UIController.fragments)
            fragmentActivity(this@UIController.fragmentActivity)
            selectedPosition(this@UIController.lastSelectedTabPosition)
            onPageChangeListener(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                }

                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                }

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }

        List(10) {
            textItem {
                id("text_Item_$it")
                title("Hello $it")
            }
        }
    }
}