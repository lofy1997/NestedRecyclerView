package com.app.nestedrecyclerview.mail

import com.airbnb.epoxy.EpoxyController
import com.app.nestedrecyclerview.mail.WLTab.ACCOUNT
import com.app.nestedrecyclerview.mail.WLTab.CREDIT
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.Tab

class UIController : EpoxyController() {

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
        List(20) {
            textItem {
                id("item_2_$it")
                title("Hello item $it")
            }
        }
    }
}