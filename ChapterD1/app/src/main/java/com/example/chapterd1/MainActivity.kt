package com.example.chapterd1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapterd1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivityMainBinding.inflate(layoutInflater).run {
            setContentView(root)

            mainFab.setOnClickListener {
                val navIntent = Intent(this@MainActivity, MainActivity2::class.java)
                    .apply {
                        putExtra("custom_text", "Sotto la panca la capra è stanca")
                    }
                startActivity(navIntent)
            }

        }

    }
}