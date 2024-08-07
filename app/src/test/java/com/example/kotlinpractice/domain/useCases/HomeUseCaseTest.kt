package com.example.kotlinpractice.domain.useCases

import com.example.kotlinpractice.domain.repository.HomeRepository
import com.example.kotlinpractice.failureQuotes
import com.example.kotlinpractice.successQuotes
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test
@ExperimentalCoroutinesApi
class HomeUseCaseTest{
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