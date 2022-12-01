package com.app.nestedrecyclerview.mail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.airbnb.epoxy.stickyheader.StickyHeaderLinearLayoutManager
import com.app.nestedrecyclerview.databinding.FragmentMailBinding
import com.app.nestedrecyclerview.mail.viewpager.WLPagerFragment
import com.app.nestedrecyclerview.mail.viewpager.WLViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MailFragment : Fragment() {

    private val uiController: UIController by lazy {
        UIController(
            fragmentActivity = requireActivity(),
            onTabSelectedListener = {

            }
        )
    }
    private var _binding: FragmentMailBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        uiController.onRestoreInstanceState(savedInstanceState)
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        uiController.onSaveInstanceState(outState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = StickyHeaderLinearLayoutManager(requireContext())
        binding.recyclerView.setController(uiController)
        binding.recyclerView.requestModelBuild()
        uiController.updateSelectedTab(0)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) = MailFragment().apply {
            arguments = Bundle().apply {

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}