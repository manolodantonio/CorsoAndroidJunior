package com.example.chapterd2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chapterd2.databinding.RowMainpageCardBinding

class MainListAdapter(
    private val elements: List<PrettyItem>,
    private val onItemClickListener: (element: PrettyItem) -> Unit
) : RecyclerView.Adapter<MainListAdapter.MainListViewHolder>() {


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

        fun bind(element: PrettyItem, onItemClickListener: (element: PrettyItem) -> Unit) {
            itemBinding.run {

                root.setOnClickListener {
                    onItemClickListener(element)
                }

                rowNameTv.text = "ID: ${element.id}"
                rowColorIv.setBackgroundColor(element.color)

                Glide.with(root)
                    .load(element.imageUrl)
                    .centerCrop()
                    .into(rowBackgroundIv)

            }
        }

    }

}