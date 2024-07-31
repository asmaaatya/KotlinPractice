package com.example.kotlinpractice.presentation.ui.home

import com.example.kotlinpractice.domain.repository.HomeRepository
import com.example.kotlinpractice.domain.useCases.HomeUseCase
import com.example.kotlinpractice.dummyQuote
import com.example.kotlinpractice.failureQuotes
import com.example.kotlinpractice.successQuotes
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class HomeViewModelTest {

    @Test
    fun `Given quote When getQuote() Then return success quote`() = runTest {

        // Given
        val homeRepository: HomeRepository = mockk()
        val homeUseCase = HomeUseCase(homeRepository)
        coEvery { homeRepository.getQuote() } coAnswers { dummyQuote }

        // When
        val result = homeUseCase.getQuote()

        // Then
        assertEquals(dummyQuote, result)
    }

    @Test
    fun `Given quotes When getQuotes() Then return success quotes`() = runTest {

        // Given
        val homeRepository: HomeRepository = mockk()
        val homeUseCase = HomeUseCase(homeRepository)
        coEvery { homeRepository.getQuotes() } coAnswers { successQuotes }

        // When
        val result = homeUseCase.getAllQuotes()

        // Then
        assertEquals(successQuotes, result)
    }

    @Test
    fun `Given quotes When getQuotes() Then return failure quotes`() = runTest {

        // Given
        val homeRepository: HomeRepository = mockk()
        val homeUseCase = HomeUseCase(homeRepository)
        coEvery { homeRepository.getQuotes() } coAnswers { failureQuotes }

        // When
        val result = homeUseCase.getAllQuotes()

        // Then
        assertEquals(failureQuotes, result)
    }
}

