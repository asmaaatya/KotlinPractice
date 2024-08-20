package com.example.kotlinpractice.presentation.ui.home

import app.cash.turbine.test
import com.example.kotlinpractice.data.model.request.ResultApiCall
import com.example.kotlinpractice.domain.useCases.HomeUseCase
import com.example.kotlinpractice.failureQuotes
import com.example.kotlinpractice.quoteList
import com.example.kotlinpractice.successQuotes
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.amshove.kluent.shouldBe
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest {
    @get:Rule
    val mainDispatcherRule = StandardDispatcherRule()
    @Test
    fun `Given the useCase - When call request, then loading result`() = runTest {
        // Given
        val useCase: HomeUseCase = mockk()
        val viewModel = HomeViewModel(useCase)
        coEvery { useCase.getAllQuotes() } returns ResultApiCall.Loading

        // Then
        viewModel.quotes.test {
            // When
            viewModel.loadQuotes()
            awaitItem() shouldBe ResultApiCall.Loading
        }
    }

    @Test
    fun `Given the useCase - When call request, then execute success result`() = runTest {
        // Given
        val useCase: HomeUseCase = mockk()
        val viewModel = HomeViewModel(useCase)
        coEvery { useCase.getAllQuotes() } returns successQuotes

        // Then
        viewModel.quotes.test {
            // When
            viewModel.loadQuotes()
            awaitItem() shouldBe ResultApiCall.Loading
            (awaitItem() as ResultApiCall.Success).data shouldBe quoteList
        }
    }
    @Test
    fun `Given the useCase - When call request, then execute failed result`() = runTest {
        // Given
        val useCase: HomeUseCase = mockk()
        val viewModel = HomeViewModel(useCase)
        coEvery { useCase.getAllQuotes() } returns failureQuotes

        // Then
        viewModel.quotes.test {
            // When
            viewModel.loadQuotes()
            awaitItem() shouldBe ResultApiCall.Loading
            (awaitItem() as ResultApiCall.Failure).message shouldBe ("error occurred")
        }
    }
}
//    @get:Rule
//    var mainRule = StandardDispatcherRule()
//
//    @Test
//    fun `Given the useCase - When call request, then execute success result`() = runTest {
//        // Given
//        val fakeHomeRepoImp = FakeHomeRepoImp()
//        val useCase = HomeUseCase(fakeHomeRepoImp)
//        val dispatcher = DefaultDispatcherProvider()
//        val viewmodel = HomeViewModel(useCase, dispatcher)
//        // When
//        viewmodel.loadQuotes()
//        // Then
//        assertEquals(successQuotes, viewmodel.quotes.value)
////        viewmodel.quotes.test {
////            assertEquals(awaitItem(), ResultApiCall.Loading)
//////            assertEquals(awaitItem(), successQuotes)
////
////        }
//    }
//
//    @Test
//    fun `test loadQuotes Success`() = runTest {
//        // Given
//        val fakeHomeRepoImp = FakeHomeRepoImp()
//        val useCase = HomeUseCase(fakeHomeRepoImp)
//        val dispatcher = DefaultDispatcherProvider()
//        val viewModel = HomeViewModel(useCase, dispatcher)
//        // When
//        viewModel.loadQuotes()
//
//        // Then
//        assertEquals(successQuotes, viewModel.quotes.value)
//        verify { Log.d("mytest", "loadQuotes  success ") }
//    }
//
//    @Test
//    fun `test loadQuotes Success2`() = runTest {
//        // Given
//        val useCase = mockk<HomeUseCase>()
//        val dispatcher = DefaultDispatcherProvider() // Use a real or test dispatcher
//        val viewModel = HomeViewModel(useCase, dispatcher)
//        // When
//        viewModel.loadQuotes()
//        advanceUntilIdle()
//        // Then
//        viewModel.quotes.test {
//            coEvery { useCase.getAllQuotes() } returns successQuotes
//            assertEquals(ResultApiCall.Loading, awaitItem())
//            assertEquals(successQuotes, awaitItem())
//        }
//        verify { Log.d("mytest", "loadQuotes  success ") }
//    }
//    @Test
//    fun `test loadQuotes Failure result`() = runTest {
//        // Given
//        val useCase = mockk<HomeUseCase>()
//        val dispatcher = DefaultDispatcherProvider()
//        val viewModel = HomeViewModel(useCase, dispatcher)
//        // When
//        viewModel.failResult()
//        // Then
//        advanceUntilIdle()
//
//        // Then
//        viewModel.quotes.test {
//            assertEquals(failureQuotes, awaitItem()) // This should now match the expected value
//            cancelAndConsumeRemainingEvents() // Clean up any remaining emissions
//        }
//
//        verify { Log.d("mytest", "loadQuotes  success ") }
//    }
//    @Test
//    fun `new test`() = runTest {
//        val _flow = MutableStateFlow<ResultApiCall<List<QuoteModel>>>(ResultApiCall.Loading)
//        val flow = _flow.asStateFlow()
//        flow.test {
//            _flow.value = successQuotes
//            assertEquals(ResultApiCall.Loading, awaitItem())
//            assertEquals(successQuotes, awaitItem())
//
//        }
//    }
//
//    @Test
//    fun `new test2`() = runTest {
//        val flow = flowOf(1, 2, 3)
//        flow.test {
//            assertEquals(1, awaitItem())
//            assertEquals(2, awaitItem())
//            assertEquals(3, awaitItem())
//            awaitComplete()
//        }
//    }

