package com.example.kotlinpractice.domain.repository

import com.example.kotlinpractice.data.model.request.Result
import com.example.kotlinpractice.domain.model.QuoteDetailsModel




interface DetailsRepository {
    suspend fun getQuoteById(id:String): Result<QuoteDetailsModel>
}