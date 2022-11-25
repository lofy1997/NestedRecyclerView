package com.app.nestedrecyclerview.mail

import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.carousel
import com.airbnb.epoxy.group
import com.airbnb.epoxy.stickyheader.StickyHeaderCallbacks
import com.app.nestedrecyclerview.R
import com.app.nestedrecyclerview.mail.WLTab.ACCOUNT
import com.app.nestedrecyclerview.mail.WLTab.CREDIT
import com.app.nestedrecyclerview.mail.header.CarouselItemModel_
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.Tab

class UIController : EpoxyController(), StickyHeaderCallbacks {

    fun updateSelectedTab(position: Int) {
        lastSelectedTabPosition = position
        requestModelBuild()
    }

    private var lastSelectedTabPosition: Int = 0

    override fun isStickyHeader(position: Int): Boolean  = adapter.getModelAtPosition(position) is WLDetailsTabBarModel

    override fun buildModels() {
        val tabs: ArrayList<WLTab> = arrayListOf(
            ACCOUNT,
            CREDIT
        )

        var carouselItems: ArrayList<CarouselItemModel_> = arrayListOf()

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
                    this@UIController.lastSelectedTabPosition = tab?.position ?: 0
                    this@UIController.requestModelBuild()
                }

                override fun onTabUnselected(tab: Tab?) {
                }

                override fun onTabReselected(tab: Tab?) {
                }
            })
        }
        List(15) {
            textItem {
                id("item_2_$it")
                title("Hello item $it")
            }
        }
    }
}