package com.example.kotlinpractice.presentation.ui.detail

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.filters.MediumTest
import androidx.test.runner.AndroidJUnit4
import com.example.kotlinpractice.R
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

//@MediumTest
@HiltAndroidTest
//@Config(application = HiltTestApplication::class)
//@RunWith(AndroidJUnit4::class)
class DetailsFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)
    @Before
    fun init() {
        hiltRule.inject()
    }
    @Test
    fun testFragmentDisplaysQuotes() {
        var homeRepo = FakeDetailsRepo()
        val scenario = launchFragmentInContainer<DetailsFragment>(
            null,
            themeResId = R.style.Theme_KotlinPractice
        )
        Thread.sleep(5000)
    }
}