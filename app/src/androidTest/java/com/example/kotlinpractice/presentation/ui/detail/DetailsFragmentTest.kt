package com.example.kotlinpractice.presentation.ui.detail

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.filters.MediumTest
import androidx.test.runner.AndroidJUnit4
import com.example.kotlinpractice.R
import com.example.kotlinpractice.presentation.ui.home.FakeHomeRepo
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@MediumTest
@HiltAndroidTest
@Config(application = HiltTestApplication::class)
@RunWith(AndroidJUnit4::class)
class DetailsFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)
    @Test
    fun testFragmentDisplaysQuotes() {
        var homeRepo = FakeHomeRepo()
        val scenario = launchFragmentInContainer<DetailsFragment>(
            null,
            themeResId = R.style.Theme_KotlinPractice
        )
        Thread.sleep(5000)
    }
}