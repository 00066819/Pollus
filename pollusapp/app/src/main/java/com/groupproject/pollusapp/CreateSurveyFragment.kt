package com.groupproject.pollusapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.groupproject.pollusapp.databinding.FragmentCreateSurveyBinding
import com.groupproject.pollusapp.ui.slideshow.SlideshowViewModel

class CreateSurveyFragment : Fragment() {

    private var _binding: FragmentCreateSurveyBinding? = null
    private val binding get() = _binding!!

    private lateinit var next_btn: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentCreateSurveyBinding.inflate(inflater, container, false)
        val root: View = binding.root

        bin()
        addlistenners()
        return root
    }

    private fun bin(){
        next_btn = binding.nextButton
    }

    private fun addlistenners(){
        next_btn.setOnClickListener(){
            findNavController().navigate(R.id.nav_questionsList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}