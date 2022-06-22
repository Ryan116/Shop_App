package com.example.shopapp.presentation

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.shopapp.R
import com.example.shopapp.databinding.ActivityMainBinding
import com.example.shopapp.presentation.viewModel.AppViewModel
import com.google.android.material.badge.BadgeDrawable
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val appViewModel by viewModel<AppViewModel>()
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addBadge("2", R.id.item2)

        appViewModel.bookmarksList.observe(this) {
            addBadge(it.size.toString(), R.id.item3)
        }

        binding.bottomNavigationView.setOnItemSelectedListener { it ->
            when (it.itemId) {
                R.id.item1 -> {
                    val uri = Uri.parse("shopapp://toMainScreen")
                    findNavController(binding.fragmentContainerView.id).navigate(uri)
                }
                R.id.item2 -> {
                    val uri = Uri.parse("shopapp://ToMyCart")
                    findNavController(binding.fragmentContainerView.id).navigate(uri)
                }
                R.id.item3 -> {
                    val uri = Uri.parse("shopapp://toBookmarksScreen")
                    findNavController(binding.fragmentContainerView.id).navigate(uri)
                }
            }
            true
        }

    }


    private fun addBadge(count: String, buttonId: Int) {
        val badge: BadgeDrawable = binding.bottomNavigationView.getOrCreateBadge(
            buttonId
        )
        badge.number = count.toInt()
        badge.isVisible = true
    }


}



