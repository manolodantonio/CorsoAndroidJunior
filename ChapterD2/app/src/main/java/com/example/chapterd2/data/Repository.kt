package com.example.chapterd2.data

import com.example.chapterd2.PrettyItem

object Repository {
    val dataset = generatePrettyItems()

    private fun generatePrettyItems() =
        MutableList(50) { PrettyItem() }
            .apply { sortBy { it.id } }
            .filter { it.id % 2 == 0 }
            .toMutableList()

    fun regenerateDataset() = dataset.apply {
        clear()
        addAll(generatePrettyItems())
    }
}