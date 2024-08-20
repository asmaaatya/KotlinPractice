package com.example.kotlinpractice.presentation.ui.home

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.filters.MediumTest
import androidx.test.runner.AndroidJUnit4
import com.example.kotlinpractice.R
import com.example.kotlinpractice.domain.useCases.HomeUseCase
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@MediumTest
@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {
    private lateinit var homeRepo: FakeHomeRepo
    private lateinit var homeViewModel: HomeViewModel



    @Test
    fun testFragmentDisplaysQuotes() {
        homeRepo = FakeHomeRepo()
        val scenario = launchFragmentInContainer<HomeFragment>(
            null,
            themeResId = R.style.Theme_KotlinPractice
        )
        Thread.sleep(5000)
    }


//    scenario.onFragment { fragment ->
//        fragment.homeViewModel = homeViewModel
//        homeViewModel.loadQuotes()
//        val result = homeViewModel.quotes.value
//        assertEquals(ResultApiCall.Success(fakeHomeRepo.getQuotes().data), result)
//    }
}