package com.example.b4unittest

class MathHelper(
    val recentResults: MutableList<Int> = mutableListOf()
) {

    fun performSum(first: Int, second: Int) = (first + second)
        .also { recentResults.add(it) }

}