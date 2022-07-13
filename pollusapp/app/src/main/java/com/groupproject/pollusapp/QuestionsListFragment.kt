package com.groupproject.pollusapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.groupproject.pollusapp.databinding.FragmentQuestionsListBinding
import com.groupproject.pollusapp.ui.slideshow.SlideshowViewModel

class QuestionsListFragment : Fragment() {

private var _binding: FragmentQuestionsListBinding? = null
private val binding get() = _binding!!

private lateinit var create_question_btn: Button
private lateinit var save_btn: Button

override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
): View {
    val slideshowViewModel =
        ViewModelProvider(this).get(SlideshowViewModel::class.java)

    _binding = FragmentQuestionsListBinding.inflate(inflater, container, false)
    val root: View = binding.root

    bin()
    addlistenners()
    return root
}

private fun bin(){
    create_question_btn = binding.btnNew
    save_btn = binding.saveQuestionsBtn
}

private fun addlistenners(){
    create_question_btn.setOnClickListener(){
        findNavController().navigate(R.id.nav_create_Question)
    }

    save_btn.setOnClickListener(){
        findNavController().navigate(R.id.nav_slideshow)
    }
}

override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
}
}