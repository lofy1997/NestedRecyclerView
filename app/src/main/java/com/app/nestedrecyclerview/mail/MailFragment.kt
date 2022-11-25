package com.app.nestedrecyclerview.mail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.nestedrecyclerview.databinding.FragmentMailBinding
import com.app.nestedrecyclerview.mail.UIController

class MailFragment : Fragment() {

    private val uiController: UIController by lazy {
        UIController()
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
        binding.recyclerView.setController(uiController)
        binding.recyclerView.requestModelBuild()
        uiController.updateSelectedTab(1)
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