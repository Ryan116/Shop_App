package com.example.shopapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.shopapp.databinding.ActivityMainBinding




class MainActivity : AppCompatActivity() {

//    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

    }
}



//        binding.bottomNavigationView.setOnItemSelectedListener {it ->
//            when (it.itemId) {
//                R.id.item2 -> {
//                    val uri = Uri.parse("shopapp://ToMyCart")
//                    findNavController(R.id.fragment_container_view).navigate(uri)
//                }
//                R.id.item3 -> {
//                    val uri = Uri.parse("shopapp://toBookmarksScreen")
//                    findNavController(R.id.fragment_container_view).navigate(uri)
//                }
//            }
//            true
//        }