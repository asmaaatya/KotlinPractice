package com.example.kotlinpractice.domain.repository

import com.example.kotlinpractice.data.model.beans.QuoteModel
import com.example.kotlinpractice.data.model.response.quotes.QuotesResponse

interface HomeRepository {
    suspend fun getQuotes() :List<QuoteModel>
}