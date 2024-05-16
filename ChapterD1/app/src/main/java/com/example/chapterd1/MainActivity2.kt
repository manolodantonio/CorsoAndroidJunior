package com.example.chapterd1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapterd1.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivityMain2Binding.inflate(layoutInflater)
            .run {
                setContentView(root)

                intent.getStringExtra("custom_text")?.let {
                    secondTv.text = it
                }



                secondFab.setOnClickListener {

                    val message = secondTv.text.toString()      //get text from view

                    val sendIntent = Intent().apply {  // New Intent
                        action = Intent.ACTION_SEND             // Type of action to perform
                        type = "text/plain"                     // Type of data to send
                        putExtra(Intent.EXTRA_TEXT, message)    // add data to Intent
                    }

                    val shareIntent = Intent.createChooser(     //Create an android share picker
                        sendIntent,
                        "Choose destination"
                    )

                    startActivity(shareIntent)                  // fire!


                }

            }
    }
}