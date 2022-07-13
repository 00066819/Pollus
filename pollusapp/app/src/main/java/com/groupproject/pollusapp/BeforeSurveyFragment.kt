package com.groupproject.pollusapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.groupproject.pollusapp.databinding.FragmentBeforeSurveyBinding
import com.groupproject.pollusapp.databinding.FragmentCreateSurveyBinding
import com.groupproject.pollusapp.ui.slideshow.SlideshowViewModel


class BeforeSurveyFragment : Fragment() {

    private var _binding: FragmentBeforeSurveyBinding? = null
    private val binding get() = _binding!!

    private lateinit var next_btn: Button
    private lateinit var arrow_back: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentBeforeSurveyBinding.inflate(inflater, container, false)
        val root: View = binding.root

        bin()
        addlistenners()
        return root
    }

    private fun bin(){
        next_btn = binding.bfBeginBtn
        arrow_back = binding.backBtn
    }

    private fun addlistenners(){
        next_btn.setOnClickListener(){
            getActivity()?.onBackPressed();
        }
        arrow_back.setOnClickListener(){
            getActivity()?.onBackPressed();
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}