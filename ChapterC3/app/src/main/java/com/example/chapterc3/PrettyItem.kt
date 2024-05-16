package com.example.chapterc3

import android.graphics.Color

fun randomColor() = (50..200).random()

data class PrettyItem(
    val id: Int = (1..999).random(),
    val color: Int = Color.rgb(randomColor(), randomColor(), randomColor())
)
