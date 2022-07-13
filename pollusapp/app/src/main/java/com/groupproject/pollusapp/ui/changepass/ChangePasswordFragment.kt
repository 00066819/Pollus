package com.groupproject.pollusapp.ui.changepass

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.groupproject.pollusapp.R
import com.groupproject.pollusapp.databinding.FragmentChangePasswordBinding
import com.groupproject.pollusapp.databinding.FragmentGalleryBinding
import com.groupproject.pollusapp.ui.gallery.GalleryViewModel

class ChangePasswordFragment : Fragment() {
    private lateinit var save_changepass: Button
    private lateinit var cancel_changepass: Button
    private var _binding: FragmentChangePasswordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val changepassViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentChangePasswordBinding.inflate(inflater, container, false)
        val root: View = binding.root
        bin()
        addlistenners()
        return root
    }

    private fun bin() {
        save_changepass = binding.saveNewpassButton
        cancel_changepass = binding.cancelNewpassButton
    }

    //funcion para darle utilidad a los botones
    private fun addlistenners() {
        save_changepass.setOnClickListener() {
            findNavController().navigate(R.id.nav_gallery)
        }
        cancel_changepass.setOnClickListener(){
            findNavController().navigate(R.id.nav_gallery)
        }
    }
}