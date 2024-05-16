package com.example.chapterc1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapterc1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        binding.run {
            setContentView(root)

            storyAddBtn.setOnClickListener {

                val newStoryText = "\n" + storyWriteTiet.text.toString()
                storyTextTv.apply {
                    text = text.toString() + newStoryText
                }
                storyWriteTiet.setText("")
            }

            storyOptionsRg.setOnCheckedChangeListener { radioGroup, checkedId ->
                val color = when(checkedId) {
                    R.id.story_options_1_rb -> android.R.color.holo_blue_light
                    R.id.story_options_3_rb -> android.R.color.holo_red_light
                    else -> R.color.white
                }
                storyTextTv.setBackgroundColor(getColor(color))
            }


        }


    }
}