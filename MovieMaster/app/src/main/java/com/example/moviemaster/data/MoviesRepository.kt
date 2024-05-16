package com.example.moviemaster.data


object MoviesRepository {

    private lateinit var moviesJson: String

    fun injectMoviesData(it: String) {
        this.moviesJson = it
    }

}