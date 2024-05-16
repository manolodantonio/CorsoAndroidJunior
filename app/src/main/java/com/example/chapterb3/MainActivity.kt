package com.example.chapterb3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        data class ColorHolder(val colors: List<String>) {
            fun hasThreeColors() = colors.size == 3
        }

        var holder: ColorHolder

        val myColors = mutableListOf("Green", "Red", "Cyan")
            .also { holder = ColorHolder(it) }

        myColors.add("Yellow")

        val message =
            if (holder.hasThreeColors())
                "Holder is good!"
            else
                "Holder is bad =("

        println(message)


    }
}


//data class ColorHolder(val colors: List<String>) {
//    fun hasThreeColors() = colors.size == 3
//
//    val colors = mutableListOf("Green", "Red", "Cyan")
//
//    val holder = ColorHolder(colors)
//
//    colors.add("Yellow")
//
//    println("Holder has exactly 3 colors: ${holder.hasThreeColors()}")