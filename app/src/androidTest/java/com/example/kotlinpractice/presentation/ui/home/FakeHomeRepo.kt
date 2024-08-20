package com.example.kotlinpractice.presentation.ui.home

import com.example.kotlinpractice.data.model.request.ResultApiCall
import com.example.kotlinpractice.domain.model.QuoteModel
import com.example.kotlinpractice.domain.repository.HomeRepository


class FakeHomeRepo:HomeRepository {
    override suspend fun getQuotes(): ResultApiCall<List<QuoteModel>> {
        return successQuotes
    }
}