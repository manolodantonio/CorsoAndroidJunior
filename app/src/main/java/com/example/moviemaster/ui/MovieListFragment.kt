package com.example.moviemaster.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.moviemaster.R
import com.example.moviemaster.databinding.FragmentMovieListBinding


class MovieListFragment : Fragment(R.layout.fragment_movie_list) {


    private val movieListAdapter = MovieListAdapter(listOf()) {
        val action = MovieListFragmentDirections.actionMovieListFragmentToMovieDetailFragment(
            it.id.toString(), ""
        )
        findNavController().navigate(action)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FragmentMovieListBinding.bind(view).run {
            movieListRv.adapter = movieListAdapter

        }

    }


}