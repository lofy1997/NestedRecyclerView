package com.app.nestedrecyclerview.mail

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.app.nestedrecyclerview.R
import com.app.nestedrecyclerview.databinding.ComponentTextItemBinding
import com.app.nestedrecyclerview.mail.TextItemModel.TextItemViewModel

@EpoxyModelClass
abstract class TextItemModel : EpoxyModelWithHolder<TextItemViewModel>() {

    @EpoxyAttribute
    var title: String? = null

    override fun bind(holder: TextItemViewModel) {
        super.bind(holder)
        holder.binding.root.text = title.toString()
    }

    override fun getDefaultLayout(): Int {
        return R.layout.component_text_item
    }

    class TextItemViewModel : EpoxyHolder() {

        lateinit var binding: ComponentTextItemBinding
            private set

        override fun bindView(itemView: View) {
            binding = ComponentTextItemBinding.bind(itemView)
        }
    }
}