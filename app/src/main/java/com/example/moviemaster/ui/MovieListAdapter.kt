package com.example.moviemaster.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviemaster.data.Movie
import com.example.moviemaster.databinding.RowMainpageCardBinding

class MovieListAdapter(
    private val elements: List<Movie>,
    private val onItemClickListener: (element: Movie) -> Unit
) : RecyclerView.Adapter<MovieListAdapter.MainListViewHolder>() {


    override fun getItemCount(): Int = elements.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListViewHolder {
        val itemBinding =
            RowMainpageCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainListViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MainListViewHolder, position: Int) {
        holder.bind(elements[position], onItemClickListener)
    }


    class MainListViewHolder(private val itemBinding: RowMainpageCardBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(element: Movie, onItemClickListener: (element: Movie) -> Unit) {
            itemBinding.run {

                root.setOnClickListener {
                    onItemClickListener(element)
                }

                rowNameTv.text = "ID: ${element.id}"

            }
        }

    }

}