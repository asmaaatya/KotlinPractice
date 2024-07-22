package com.example.kotlinpractice.domain.repository

import com.example.kotlinpractice.data.model.response.quotesDetails.QuoteDetailsResponse

interface DetailsRepository {
    suspend fun getQuoteById(id:String):QuoteDetailsResponse
}