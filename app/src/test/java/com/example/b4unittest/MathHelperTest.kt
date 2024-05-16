package com.example.b4unittest

import com.google.common.truth.Truth.*

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MathHelperTest {

    //test subject
    lateinit var mathHelper: MathHelper

    @Before
    fun before() {
        mathHelper = MathHelper()
    }

    @After
    fun after() {
        mathHelper.recentResults.clear()
    }


    @Test
    fun recentResults_noResults_oneResult() {
        mathHelper.performSum(5, 5)
        assertThat(mathHelper.recentResults.size).isEqualTo(1)
    }

    @Test
    fun recentResults_oneResults_twoResults() {
        mathHelper.recentResults.add(99)
        val result = mathHelper.performSum(5, 5)
        assertThat(mathHelper.recentResults[1]).isEqualTo(result)
    }

    @Test
    fun performSum_twoPositives_success() {
        val testNumber = 5
        val result = mathHelper.performSum(testNumber, testNumber)
        assertThat(testNumber).isGreaterThan(0)
        assertThat(result).isEqualTo(10)
    }

    @Test
    fun performSum_twoNegatives_success() {
        val result = mathHelper.performSum(-5, -5)
        assertThat(result).isEqualTo(-10)
    }

    @Test
    fun performSum_oneNegative_success() {
        val result = mathHelper.performSum(-5, 5)
        assertThat(result).isEqualTo(0)
    }




}