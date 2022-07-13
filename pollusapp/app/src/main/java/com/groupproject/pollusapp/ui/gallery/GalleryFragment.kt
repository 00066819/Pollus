package com.groupproject.pollusapp.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.groupproject.pollusapp.ChangePass
import com.groupproject.pollusapp.R
import com.groupproject.pollusapp.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    private lateinit var btn_changepass: Button

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

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

    //funcion utilizada para inicializar objetos
    private fun bin(){
        btn_changepass = binding.changePassButton
    }

    //funcion para darle utilidad a los botones
    private fun addlistenners(){
        btn_changepass.setOnClickListener(){
            findNavController().navigate(R.id.changePass)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}