package com.example.moviemaster

import android.os.Bundle
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.example.moviemaster.ui.MovieListAdapter
import com.example.moviemaster.ui.MovieListFragment
import com.google.common.truth.Truth
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito

@RunWith(AndroidJUnit4::class)
@MediumTest
class MovieListFragmentTest {

    lateinit var scenario: FragmentScenario<MovieListFragment>
    lateinit var dataset: List<Movie>

    @Before
    fun setUp() {
        scenario = launchFragmentInContainer<MovieListFragment>(Bundle(), R.style.Theme_ChapterC3)
            .apply {
                onFragment {
                    dataset = it.dataset
                }
            }
    }

    @Test
    fun fabIsClickable() {
        onView(withId(R.id.main_refresh_fab))
            .perform(click())
            .check(ViewAssertions.matches(isDisplayed()))
    }

    @Test
    fun fabClick_listRefreshed() {
        val oldDataset = mutableListOf<Movie>().apply { addAll(dataset) }
        onView(withId(R.id.main_refresh_fab)).perform(click())
        Truth.assertThat(dataset).isNotEqualTo(oldDataset)


        val textToMatch = "ID: ${dataset.last().id}"

        onView(withId(R.id.main_list_rv))
            .perform(
                RecyclerViewActions.scrollTo<MovieListAdapter.MainListViewHolder>(
                    hasDescendant(withText(textToMatch))
                )
            )

        onView(withText(textToMatch))
            .check(ViewAssertions.matches(isDisplayed()))
    }


    @Test
    fun clickListItem_navigateToDetail() {
        //Test subject (mock)
        val navController = Mockito.mock(NavController::class.java)
        scenario.onFragment { fragment ->
            // Set the graph on the TestNavHostController
            navController.setGraph(R.navigation.nav_graph)

            // Make the NavController available via the findNavController() APIs
            Navigation.setViewNavController(fragment.requireView(), navController)
        }


        val firstItem = dataset.first()

        onView(withId(R.id.main_list_rv))
            .perform(
                RecyclerViewActions.actionOnItem<MovieListAdapter.MainListViewHolder>(
                    hasDescendant(withText("ID: ${firstItem.id}")),
                    click()
                )
            )

        Mockito.verify(navController)
            .navigate(
                MainListFragmentDirections.actionMainListFragmentToMainDetailFragment(
                    firstItem.id.toString(),
                    firstItem.imageUrl
                )
            )
    }

}

