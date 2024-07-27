package com.example.kotlinpractice.data.remote.apis

import com.example.kotlinpractice.data.model.response.quotes.QuotesResponse
import com.example.kotlinpractice.data.model.response.quotesDetails.QuoteDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APiService {
    @GET("quotes")
    suspend fun getQuotesList(
        @Query("sortBy") sortBy: String = "dateAdded",
        @Query("order") order: String = "asc",
        @Query("limit") limit: Int = 20,
        @Query("page") page: Int = 1
    ): QuotesResponse

    @GET("quotes/{id}")
    suspend fun getQuoteById(@Path("id") id: String): QuoteDetailsResponse
}