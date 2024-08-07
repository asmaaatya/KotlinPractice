package com.example.kotlinpractice.domain.useCases

import com.example.kotlinpractice.data.model.request.ResultApiCall
import com.example.kotlinpractice.domain.model.QuoteDetailsModel
import com.example.kotlinpractice.domain.repository.DetailsRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

@ExperimentalCoroutinesApi
class DetailsUseCaseTest{
    @Test
    fun getDetails_success() = runTest {
        //given id
        val detailsRepository: DetailsRepository = mockk()
        val detailsUseCase = DetailsUseCase(detailsRepository)
        val id = "dgfdhdj"
        val quoteDetailsModel = QuoteDetailsModel("author name", listOf("wisdom", "nothing"))
        //when
        coEvery { detailsUseCase.getDetails(id) } coAnswers { ResultApiCall.Success(quoteDetailsModel) }
        //then
        val result = detailsUseCase.getDetails(id)
        assertEquals(ResultApiCall.Success(quoteDetailsModel), result)


    }

    @Test
    fun getDetails_failed() = runTest {
        //given id
        val detailsRepository: DetailsRepository = mockk()
        val detailsUseCase = DetailsUseCase(detailsRepository)
        val id = "dgfdhdj"
        val error = "error occured"
        coEvery { detailsUseCase.getDetails(id) } coAnswers { ResultApiCall.Failure(error) }
        //when
        val result = detailsUseCase.getDetails(id)

        //then
        assertEquals(ResultApiCall.Failure(error), result)


    }
}