package com.example.shopapp.presentation

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.shopapp.databinding.ActivitySplashBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private var _binding: ActivitySplashBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigateToMainScreen()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun navigateToMainScreen() {

        val intent = Intent(this, MainActivity::class.java)

        lifecycleScope.launch {
            withContext(Dispatchers.Main) {
                logoAnimation()
                startActivity(intent)
                finish()
            }
        }
    }

    private suspend fun logoAnimation() {
        binding.imageViewSplashLogo.animate().apply {
            duration = 2000
            rotationYBy(360f)
        }.start()
        delay(2000)
    }
}