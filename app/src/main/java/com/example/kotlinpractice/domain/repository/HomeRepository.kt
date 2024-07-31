package com.example.kotlinpractice.domain.repository

import com.example.kotlinpractice.data.model.request.ResultApiCall
import com.example.kotlinpractice.domain.model.QuoteModel

interface HomeRepository {
    suspend fun getQuotes(): ResultApiCall<List<QuoteModel>>
    suspend fun getQuote(): QuoteModel
}