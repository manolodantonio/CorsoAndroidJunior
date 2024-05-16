package com.example.chapter_b_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.core.math.MathUtils
import com.example.chapter_b_2.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.run {

            mainLabelTv.text = getString(R.string.label_activation_ready)
            mainActionBtn.apply {
                text = getString(R.string.label_activate)
                setOnClickListener {
                    Log.d("onClick", "Clicked!")
                    mainLabelTv.text = getLabelText(mainLabelTv)
                }
            }

        }



    }

    private fun getLabelText(mainLabelTv: TextView): String {
        val activatedString = getString(R.string.label_activation_complete)
        val readyString = getString(R.string.label_activation_ready)



        return when (mainLabelTv.text) {
            activatedString -> readyString
            readyString -> activatedString
            else -> "Error! I don't know this text."
        }

    }


}