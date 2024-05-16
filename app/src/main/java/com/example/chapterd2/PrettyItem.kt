package com.example.chapterd2

import android.graphics.Color

fun randomColor() = (50..200).random()

data class PrettyItem(
    val id: Int = (1..999).random(),
    val color: Int = Color.rgb(randomColor(), randomColor(), randomColor())
) {
    val imageUrl = "https://picsum.photos/id/$id/500/500"
}
