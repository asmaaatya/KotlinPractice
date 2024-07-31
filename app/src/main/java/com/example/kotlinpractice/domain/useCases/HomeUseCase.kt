package com.example.kotlinpractice.domain.useCases

import com.example.kotlinpractice.data.model.request.ResultApiCall
import com.example.kotlinpractice.domain.model.QuoteModel
import com.example.kotlinpractice.domain.repository.HomeRepository
import javax.inject.Inject

class HomeUseCase @Inject constructor(private val homeRepository: HomeRepository) {

    suspend fun getAllQuotes(): ResultApiCall<List<QuoteModel>> {
        return homeRepository.getQuotes()
    }

    suspend fun getQuote(): QuoteModel {
        return homeRepository.getQuote()
    }

}