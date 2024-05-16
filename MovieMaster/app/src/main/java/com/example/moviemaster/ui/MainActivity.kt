package com.example.moviemaster.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.moviemaster.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        binding.run {
            setContentView(root)
        }

    }
}



