package com.groupproject.pollusapp.ui.createQuestion

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.groupproject.pollusapp.R
import com.groupproject.pollusapp.databinding.FragmentCreateQuestionBinding
import com.groupproject.pollusapp.databinding.FragmentHomeBinding
import com.groupproject.pollusapp.ui.home.HomeViewModel
import com.groupproject.pollusapp.ui.slideshow.SlideshowViewModel

class Create_Question : Fragment() {

    private var _binding: FragmentCreateQuestionBinding? = null
    private val binding get() = _binding!!

    private lateinit var create_back: ImageButton
    private lateinit var login_btn: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentCreateQuestionBinding.inflate(inflater, container, false)
        val root: View = binding.root

        bin()
        addlistenners()
        return root
    }

    private fun bin(){
        create_back = binding.backBtn
        login_btn = binding.loginGoogleButton
    }

    //funcion para darle utilidad a los botones
    private fun addlistenners(){
        create_back.setOnClickListener(){
            getActivity()?.onBackPressed();
        }

        login_btn.setOnClickListener(){
            getActivity()?.onBackPressed();
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}