package com.example.chapterc3

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.google.common.truth.Truth.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@MediumTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    lateinit var scenario: ActivityScenario<MainActivity>
    lateinit var dataset: List<PrettyItem>

    @Before
    fun before() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.onActivity {
            dataset = it.dataset
        }
    }

    @After
    fun after() {
        scenario.close()
    }

    @Test
    fun fabIsClickable() {
        onView(withId(R.id.main_refresh_fab))
            .perform(click())
            .check(matches(isDisplayed()))
    }

    @Test
    fun fabClick_listRefreshed() {
        val oldDataset = mutableListOf<PrettyItem>().apply { addAll(dataset) }
        onView(withId(R.id.main_refresh_fab)).perform(click())
        assertThat(dataset).isNotEqualTo(oldDataset)


        val textToMatch = "ID: ${dataset.last().id}"

        onView(withId(R.id.main_list_rv))
            .perform(
                RecyclerViewActions.scrollTo<MainListAdapter.MainListViewHolder>(
                    hasDescendant(withText(textToMatch))
                )
            )

        onView(withText(textToMatch))
            .check(matches(isDisplayed()))
    }

}