package com.example.shopapp.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.shopapp.databinding.ActivitySplashBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashActivity : AppCompatActivity() {

    private var _binding: ActivitySplashBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, MainActivity::class.java)

        lifecycleScope.launch {
            withContext(Dispatchers.Main) {
                binding.imageViewSplashLogo.animate().apply {
                    duration = 2000
                    rotationYBy(360f)
                    delay(2500)
                    startActivity(intent)
                    finish()
                }.start()
            }

        }
    }


}