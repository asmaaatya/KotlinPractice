package com.example.kotlinpractice.domain.useCases

import com.example.kotlinpractice.data.model.request.ResultApiCall
import com.example.kotlinpractice.domain.model.QuoteDetailsModel
import com.example.kotlinpractice.domain.repository.DetailsRepository
import javax.inject.Inject

class DetailsUseCase @Inject constructor(private val detailsRepository: DetailsRepository){
    suspend fun getDetails(id:  String): ResultApiCall<QuoteDetailsModel> {
      return detailsRepository.getQuoteById(id)
    }
}