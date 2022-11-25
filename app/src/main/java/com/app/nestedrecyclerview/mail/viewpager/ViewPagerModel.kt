package com.app.nestedrecyclerview.mail.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyAttribute.Option.DoNotHash
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.EpoxyModelClass
import com.app.nestedrecyclerview.R

@EpoxyModelClass
abstract class ViewPagerModel : EpoxyModel<CustomViewPager>() {

    @EpoxyAttribute(DoNotHash)
    var selectedPosition = 0

    @EpoxyAttribute(DoNotHash)
    var fragmentActivity: FragmentActivity? = null

    @EpoxyAttribute
    var fragments: ArrayList<Fragment> = arrayListOf()

    @EpoxyAttribute(DoNotHash)
    var onPageChangeListener: ViewPager2.OnPageChangeCallback? = null

    override fun getDefaultLayout(): Int {
        return R.layout.component_viewpager
    }

    override fun shouldSaveViewState(): Boolean {
        return true
    }

    override fun bind(view: CustomViewPager) {
        super.bind(view)
        view.binding(
            fragments = fragments,
            selectionPosition = selectedPosition,
            fragmentActivity = fragmentActivity!!,
            onPageChangeListener = onPageChangeListener!!
        )
    }
}