package com.groupproject.pollusapp.ui.gallery

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.groupproject.pollusapp.MainActivity
import com.groupproject.pollusapp.R
import com.groupproject.pollusapp.Register
import com.groupproject.pollusapp.databinding.FragmentGalleryBinding
import com.groupproject.pollusapp.network.RetrofitInstance
import com.groupproject.pollusapp.ui.login.LoginViewModel

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    private lateinit var btn_changepass: Button
    private lateinit var btn_logout: Button
    private val logInViewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        bin()
        addlistenners()
        return root
    }

    private fun bin(){
        btn_changepass = binding.changePassButton
        btn_logout = binding.logoutButton
    }

    private fun addlistenners(){
        btn_changepass.setOnClickListener(){
            findNavController().navigate(R.id.nav_changepassword)
        }
        btn_logout.setOnClickListener(){

            RetrofitInstance.setToken(null)
            findNavController().navigate(R.id.login)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}