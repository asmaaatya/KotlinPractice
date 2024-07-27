package com.example.kotlinpractice.domain.repository

import com.example.kotlinpractice.data.model.request.Result
import com.example.kotlinpractice.domain.model.QuoteModel

interface HomeRepository {
    suspend fun getQuotes() :Result<List<QuoteModel>>
}