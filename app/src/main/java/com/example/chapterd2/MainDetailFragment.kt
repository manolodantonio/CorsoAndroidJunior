package com.example.chapterd2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.chapterd2.databinding.FragmentMainDetailBinding

class MainDetailFragment : Fragment(R.layout.fragment_main_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: MainDetailFragmentArgs by navArgs()

        FragmentMainDetailBinding.bind(view).run {
            detailIdTv.text = "ID: ${args.id}"
            Glide.with(this@MainDetailFragment)
                .load(args.imageUrl)
                .into(detailImageIv)
        }

    }

}