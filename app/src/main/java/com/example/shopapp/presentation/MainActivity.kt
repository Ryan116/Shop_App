package com.example.shopapp.presentation

import android.os.Bundle
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
                R.id.itemMainFragment -> {
                    findNavController(binding.fragmentContainerView.id).navigate(R.id.action_to_mainFragment)
                }
                R.id.item2 -> {
                    findNavController(binding.fragmentContainerView.id).navigate(R.id.action_to_myCartFragment)
                }
                R.id.item3 -> {
                    findNavController(binding.fragmentContainerView.id).navigate(R.id.action_to_bookmarksFragment)
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



