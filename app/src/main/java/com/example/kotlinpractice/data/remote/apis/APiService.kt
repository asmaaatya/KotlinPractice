package com.example.kotlinpractice.data.remote.apis

import com.example.kotlinpractice.data.model.response.quotes.QuotesResponse
import com.example.kotlinpractice.data.model.response.quotesDetails.QuoteDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APiService {
//https://api.quotable.io/quotes?sortBy=dateAdded&order=asc&limit=20&page=1
    @GET("quotes")
    fun getQuotesList(@Query("sortBy") sortBy:String="dateAdded",
                      @Query("order") order:String="asc",
                      @Query("limit") limit:Int=20,
                      @Query("page") page:Int=1):QuotesResponse
    //https://api.quotable.io/quotes/:id
    @GET("quotes/{id}")
    fun getQuoteById(@Path("id") id:String):QuoteDetailsResponse
    // todo 4- we should add some endpoints here
}