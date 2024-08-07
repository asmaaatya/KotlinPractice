package com.example.kotlinpractice.data.repository.home

import com.example.kotlinpractice.data.mapper.mapToQuotesList
import com.example.kotlinpractice.data.model.request.ResultApiCall
import com.example.kotlinpractice.data.model.response.quotes.Quote
import com.example.kotlinpractice.data.model.response.quotes.QuotesResponse
import com.example.kotlinpractice.data.remote.apis.APiService
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeRepositoryImpTest {

    @Test
    fun `getAllQuotes should return success when API call is successful`() = runTest {
        // Given
        val apiService: APiService = mockk()
        val homeRepoImp = HomeRepositoryImp(apiService)
        val quotes = listOf(
            Quote(
                _id = "1",
                author = "Author",
                authorSlug = "author-slug",
                content = "This is a quote",
                dateAdded = "2023-07-26",
                dateModified = "2023-07-26",
                length = 20,
                tags = listOf("inspiration", "life")
            )
        )
        val quotesResponse = QuotesResponse(
            count = 1,
            lastItemIndex = 0,
            page = 1,
            results = quotes,
            totalCount = 1,
            totalPages = 1
        )

        coEvery { apiService.getQuotesList() } coAnswers { quotesResponse }
        // When
        val result = homeRepoImp.getQuotes()
        // Then
        assertEquals(ResultApiCall.Success(quotesResponse.mapToQuotesList()), result)
    }

    @Test
    fun `getAllQuotes should return failure when API call failed`() = runTest {
        //Given
        val apiService: APiService = mockk()
        val homeRepoImp = HomeRepositoryImp(apiService)
        coEvery { apiService.getQuotesList()} throws Exception("error")
        //coAnswers { quotesResponse }
//        every{apiService.getQuotesList() }.throws(Exception("error"))
//        val exception= assertThrows(Exception::class.java){homeRepoImp.getQuotes()  }
        // When
        val result = homeRepoImp.getQuotes()
        // Then
        assertEquals(ResultApiCall.Failure("error"), result)
    }

    //        var exceptionThrow:Boolean=false
//        try{
//
//        }catch(e:Exception){
//           exceptionThrow=true
//        }
//        assertTrue(exceptionThrow)
}