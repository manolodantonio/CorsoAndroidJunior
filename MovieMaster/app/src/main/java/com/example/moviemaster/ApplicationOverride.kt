package com.example.moviemaster

import android.app.Application
import com.example.moviemaster.data.MoviesRepository
import java.io.BufferedReader

class ApplicationOverride : Application() {

    override fun onCreate() {
        super.onCreate()

        resources.openRawResource(R.raw.movies)
            .bufferedReader().use(BufferedReader::readText)
            .let { MoviesRepository.injectMoviesData(it) }

    }

}