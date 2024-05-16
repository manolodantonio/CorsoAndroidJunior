package com.example.chapterd2

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.chapterd2.data.Repository
import com.google.common.truth.Truth.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun before() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @After
    fun after() {
        scenario.close()
    }

    @Test
    fun listClick_detailShow_correctData() {
        val firstItem = Repository.dataset.first()

        onView(withId(R.id.main_list_rv))
            .perform(
                RecyclerViewActions.actionOnItem<MainListAdapter.MainListViewHolder>(
                    hasDescendant(withText("ID: ${firstItem.id}")),
                    ViewActions.click()
                )
            )

        onView(withId(R.id.detail_id_tv)).check(matches(isDisplayed()))

        onView(withId(R.id.detail_id_tv)).check(matches(withText("ID: ${firstItem.id}")))

    }


}