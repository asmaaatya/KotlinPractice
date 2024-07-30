package com.example.kotlinpractice.presentation.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.kotlinpractice.data.model.request.Result
import com.example.kotlinpractice.domain.model.QuoteModel
import com.example.kotlinpractice.domain.useCases.HomeUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest {
    val testDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()
    private val testScope = TestScope(testDispatcher)

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()
    lateinit var homeViewModel: HomeViewModel
    lateinit var homeUseCase: HomeUseCase

    @Before
    fun setupViewModel() {
        homeUseCase = mockk()
        homeViewModel = HomeViewModel(homeUseCase)
    }
//Given: Setup the objects and the state of the app that you need for your test.
//When: Do the actual action on the object you're testing.
//Then: This is where you actually check what happens when you do the action where you check if the test passed or failed.

    @Test
    fun loadQuotes_success() = runTest {
        //given list of quotes
        val quoteList = listOf(QuoteModel("1", "nice quote", "29-7-2024"))
        //call get quote service
        coEvery { homeUseCase.getAllQuotes() } coAnswers { Result.Success(quoteList) }
        //when
        val result = homeUseCase.getAllQuotes()
        //then
        //assert equals
        assertEquals(Result.Success(quoteList).data, result)
    }


    @Test
    fun loadQuotes_failure() = runTest {
        //given error
        val exception = Exception("Error fetching data")
        //its failed to get data
        coEvery { homeUseCase.getAllQuotes() } coAnswers { Result.Failure(exception.message.toString()) }
        //then
        assertEquals(
            Result.Failure("Error fetching data"), "error within data"
        )
    }
}

