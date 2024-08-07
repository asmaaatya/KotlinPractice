package com.example.kotlinpractice.data.repository.detail

import com.example.kotlinpractice.data.mapper.mapDetailsToUi
import com.example.kotlinpractice.data.model.request.ResultApiCall
import com.example.kotlinpractice.data.model.response.quotesDetails.QuoteDetailsResponse
import com.example.kotlinpractice.data.remote.apis.APiService
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

@ExperimentalCoroutinesApi
class DetailsRepositoryImpTest {
    @Test
    fun `getQuoteById should return success when API call is successful`() = runTest {
        //Given
        val apiService: APiService = mockk()
        val detailsRepoImp = DetailsRepositoryImp(apiService)
        val id = "2324"
        val quoteDetailsResponse = QuoteDetailsResponse(
            _id = "1",
            author = "Author",
            authorSlug = "author-slug",
            content = "This is a quote",
            dateAdded = "2023-07-26",
            dateModified = "2023-07-26",
            length = 20,
            tags = listOf("inspiration", "life")
        )
        coEvery { apiService.getQuoteById(id) } coAnswers { quoteDetailsResponse }
        //when
        val result = detailsRepoImp.getQuoteById(id)
        // Then
        assertEquals(ResultApiCall.Success(quoteDetailsResponse.mapDetailsToUi()), result)
    }
    @Test
    fun `getQuoteById should return failure when API call failed`() = runTest {
        //Given
        val apiService: APiService = mockk()
        val detailsRepoImp = DetailsRepositoryImp(apiService)
        val id = "2324"
        coEvery { apiService.getQuoteById(id) } throws Exception("error")
        //when
        val result = detailsRepoImp.getQuoteById(id)
        // Then
        assertEquals(ResultApiCall.Failure("error"), result)
    }
}