package com.example.kotlinpractice.domain.repository

import com.example.kotlinpractice.data.model.beans.QuoteDetailsModel




interface DetailsRepository {
    suspend fun getQuoteById(id:String):QuoteDetailsModel
}