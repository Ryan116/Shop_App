package com.example.shopapp.features.mainScreen.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.shopapp.R
import com.example.shopapp.databinding.FragmentImageBinding
import com.example.shopapp.databinding.FragmentMainBinding
import com.example.shopapp.features.mainScreen.presentation.viewModel.MainViewModel
import com.squareup.picasso.Picasso

const val IMAGE_POSITION = "imagePos"

class ImageFragment : Fragment() {
    private lateinit var binding: FragmentImageBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentImageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val picasso = Picasso.get()
        val list = mainViewModel.phones.value

        arguments?.takeIf {
            it.containsKey(IMAGE_POSITION)
        }?.apply {
            binding.textView.text = getInt(IMAGE_POSITION).toString()
//            when(getInt(IMAGE_POSITION)) {
//                0 -> {
//                    picasso.load()
//                }
//            }
        }
    }



}