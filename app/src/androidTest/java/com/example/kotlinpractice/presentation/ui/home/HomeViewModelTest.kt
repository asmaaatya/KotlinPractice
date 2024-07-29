package com.example.kotlinpractice.presentation.ui.home

import com.example.kotlinpractice.domain.useCases.HomeUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest {
    val testDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()
    lateinit var homeViewModel: HomeViewModel
    lateinit var homeUseCase: HomeUseCase
    @Before
    fun setupViewModel() {
        homeUseCase=mockk
        homeViewModel=HomeViewModel(homeUseCase)
    }



    @Test
    fun loadQuotes_success(){

    }
    @Test
    fun loadQuotes_failure(){

    }

}