package com.app.nestedrecyclerview.mail

import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.nestedrecyclerview.databinding.FragmentMailBinding

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
        binding.toolbar.background.alpha = (0.5 * 255).toInt()
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