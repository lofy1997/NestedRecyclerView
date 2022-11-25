package com.app.nestedrecyclerview.mail.header

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.app.nestedrecyclerview.R
import com.app.nestedrecyclerview.databinding.ComponentCarouselItemBinding
import com.app.nestedrecyclerview.mail.header.CarouselItemModel.CarouselItemViewHolder

@EpoxyModelClass
abstract class CarouselItemModel : EpoxyModelWithHolder<CarouselItemViewHolder>() {

    @EpoxyAttribute
    var title: String? = null

    override fun bind(holder: CarouselItemViewHolder) {
        super.bind(holder)
        holder.binding.textView.text = title
    }

    override fun getDefaultLayout(): Int {
        return R.layout.component_carousel_item
    }

    class CarouselItemViewHolder : EpoxyHolder() {

        lateinit var binding: ComponentCarouselItemBinding
            private set

        override fun bindView(itemView: View) {
            binding = ComponentCarouselItemBinding.bind(itemView)
        }
    }
}