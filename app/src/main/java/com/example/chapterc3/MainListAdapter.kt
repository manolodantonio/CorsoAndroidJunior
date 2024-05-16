package com.example.chapterc3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chapterc3.databinding.RowMainpageBinding
import com.example.chapterc3.databinding.RowMainpageCardBinding

class MainListAdapter(private val elements: List<PrettyItem>) :
    RecyclerView.Adapter<MainListAdapter.MainListViewHolder>() {

    class MainListViewHolder(private val itemBinding: RowMainpageCardBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(element: PrettyItem) {
            itemBinding.run {
                rowNameTv.text = "ID: ${element.id}"
                rowColorIv.setBackgroundColor(element.color)

                Glide.with(root)
                    .load("https://picsum.photos/id/${element.id}/500/100")
                    .centerCrop()
                    .into(rowBackgroundIv)
            }
        }

    }

    override fun getItemCount(): Int = elements.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListViewHolder {
        val itemBinding =
            RowMainpageCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainListViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MainListViewHolder, position: Int) {
        holder.bind(elements[position])
    }


}