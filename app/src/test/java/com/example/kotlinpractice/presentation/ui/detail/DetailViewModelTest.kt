package com.example.kotlinpractice.presentation.ui.detail

import app.cash.turbine.test
import com.example.kotlinpractice.data.model.request.ResultApiCall
import com.example.kotlinpractice.domain.model.QuoteDetailsModel
import com.example.kotlinpractice.domain.useCases.DetailsUseCase
import com.example.kotlinpractice.presentation.ui.home.StandardDispatcherRule
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.amshove.kluent.shouldBe
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class DetailViewModelTest {
    @get:Rule
    val mainDispatcherRule = StandardDispatcherRule()

    @Test
    fun `Given the useCase - When call request, then loading result`() = runTest {
        // Given
        val useCase: DetailsUseCase = mockk()
        val viewModel = DetailViewModel(useCase)
        val id="1234"
        coEvery { useCase.getDetails(id)} returns ResultApiCall.Loading
        // Then
        viewModel.details.test {
            // When
            viewModel.getDetails(id)
            awaitItem() shouldBe ResultApiCall.Loading
        }
    }
    @Test
    fun `Given the useCase - When call request, then execute success result`() = runTest {
        // Given
        val useCase: DetailsUseCase = mockk()
        val viewModel = DetailViewModel(useCase)
        val id="1234"
        val quoteDetailsModel = QuoteDetailsModel("author name", listOf("wisdom", "nothing"))
        coEvery { useCase.getDetails(id) } returns ResultApiCall.Success(quoteDetailsModel)

        // Then
        viewModel.details.test {
            // When
            viewModel.getDetails(id)
            awaitItem() shouldBe ResultApiCall.Loading
            (awaitItem() as ResultApiCall.Success).data shouldBe quoteDetailsModel
        }
    }
    @Test
    fun `Given the useCase - When call request, then execute failure result`() = runTest {
        // Given
        val useCase: DetailsUseCase = mockk()
        val viewModel = DetailViewModel(useCase)
        val id="1234"
        coEvery { useCase.getDetails(id) } returns ResultApiCall.Failure("error occured")

        // Then
        viewModel.details.test {
            // When
            viewModel.getDetails(id)
            awaitItem() shouldBe ResultApiCall.Loading
            (awaitItem() as ResultApiCall.Failure).message shouldBe("error occured")
        }
    }

}
