package com.example.kotlinpractice.data.repository.home

import com.example.kotlinpractice.data.mapper.QuoteMapper
import com.example.kotlinpractice.data.model.beans.QuoteModel
import com.example.kotlinpractice.data.model.response.quotes.QuotesResponse
import com.example.kotlinpractice.data.remote.apis.APiService
import com.example.kotlinpractice.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImp @Inject constructor(private val apiService: APiService) : HomeRepository {
    override suspend fun getQuotes(): List<QuoteModel>  {
        val quotesResponse= apiService.getQuotesList()
        return QuoteMapper.mapToUiModelList(quotesResponse)
    }
}