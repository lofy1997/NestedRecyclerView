package com.app.nestedrecyclerview.mail

import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyAttribute.Option.DoNotHash
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.EpoxyModelClass
import com.app.nestedrecyclerview.R
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

@EpoxyModelClass
abstract class WLDetailsTabBarModel: EpoxyModel<WLDetailsTabBar>() {

    /**
     * The selected position changes due to user input to the tab view, so that tab view already knows about position changes. We just need to tell it
     * the correct starting position, but have it trigger change updates.
     */
    @EpoxyAttribute(DoNotHash)
    var selectedPosition = 0

    @EpoxyAttribute
    var tabs: ArrayList<WLTab> = arrayListOf()

    @EpoxyAttribute(DoNotHash)

    var onTabSelectedListener: OnTabSelectedListener? = null

    override fun shouldSaveViewState(): Boolean {
        return true
    }

    override fun getDefaultLayout(): Int {
        return R.layout.wl_details_tab_bar_item
    }

    override fun bind(view: WLDetailsTabBar) {
        super.bind(view)
        view.bind(tabs, selectedPosition, onTabSelectedListener!!)
    }

}