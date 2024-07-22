package com.example.kotlinpractice.data.repository.detail

import com.example.kotlinpractice.data.model.response.quotesDetails.QuoteDetailsResponse
import com.example.kotlinpractice.data.remote.apis.APiService
import com.example.kotlinpractice.domain.repository.DetailsRepository
import javax.inject.Inject

class DetailsRepositoryImp @Inject constructor(private val apiService: APiService):DetailsRepository {
    override suspend fun getQuoteById(id:String): QuoteDetailsResponse {
       return apiService.getQuoteById(id)
    }
}