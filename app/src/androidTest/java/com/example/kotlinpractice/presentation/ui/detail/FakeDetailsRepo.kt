package com.example.kotlinpractice.presentation.ui.detail

import com.example.kotlinpractice.data.model.request.ResultApiCall
import com.example.kotlinpractice.domain.model.QuoteDetailsModel
import com.example.kotlinpractice.domain.repository.DetailsRepository

class FakeDetailsRepo :DetailsRepository {
    override suspend fun getQuoteById(id: String): ResultApiCall<QuoteDetailsModel> {
        return ResultApiCall.Success(QuoteDetailsModel(id, listOf("Fake Quote","non fake quote")))
    }
}