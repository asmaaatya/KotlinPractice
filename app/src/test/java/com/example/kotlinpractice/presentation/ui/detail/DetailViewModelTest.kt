package com.example.kotlinpractice.presentation.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.kotlinpractice.data.model.request.ResultApiCall
import com.example.kotlinpractice.domain.model.QuoteDetailsModel
import com.example.kotlinpractice.domain.useCases.DetailsUseCase
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
class DetailViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    var coroutineDispatcher = TestCoroutineDispatcher()
    private val testScope = TestScope(coroutineDispatcher)
    lateinit var detailViewModel: DetailViewModel
    lateinit var detailsUseCase: DetailsUseCase

    @Before
    fun setUpViewModel() {
        detailsUseCase = mockk()
        detailViewModel = DetailViewModel(detailsUseCase)
    }



    @Test
    fun getDetails_success() = runTest {
        //given id
        val id = "dgfdhdj"
        val quoteDetailsModel = QuoteDetailsModel("author name", listOf("wisdom", "nothing"))
        //when
        coEvery { detailsUseCase.getDetails(id) } coAnswers { ResultApiCall.Success(quoteDetailsModel) }
        //then
        val result = detailsUseCase.getDetails(id)
        assertEquals(ResultApiCall.Success(quoteDetailsModel).data, result)


    }

    @Test
    fun getDetails_failed() = runTest {
        //given id
        val id = "dgfdhdj"
        val error = "error occured"
        coEvery { detailsUseCase.getDetails(id) } coAnswers { ResultApiCall.Failure(error) }
        //when
        val result = detailsUseCase.getDetails(id)

        //then
        assertEquals(ResultApiCall.Failure(error), result)


    }
}
