package com.example.chapterc3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.VisibleForTesting
import com.example.chapterc3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val dataset = generatePrettyItems()

    private val mainListAdapter = MainListAdapter(dataset)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        binding.run {
            setContentView(root)

            mainListRv.adapter = mainListAdapter

            mainRefreshFab.setOnClickListener {
                dataset.apply {
                    clear()
                    addAll(generatePrettyItems())
                }
                mainListAdapter.notifyDataSetChanged()
            }

        }
    }



    private fun generatePrettyItems() =
        MutableList(50) { PrettyItem() }
            .apply { sortBy { it.id } }
            .filter { it.id % 2 == 0 }
            .toMutableList()

    private fun generateByFibonacci() =
        listOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 34).map { PrettyItem(it) }


}