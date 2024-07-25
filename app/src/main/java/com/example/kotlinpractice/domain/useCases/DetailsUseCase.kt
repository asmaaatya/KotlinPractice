package com.example.kotlinpractice.domain.useCases

import com.example.kotlinpractice.data.model.beans.QuoteDetailsModel
import com.example.kotlinpractice.domain.repository.DetailsRepository
import javax.inject.Inject

class DetailsUseCase @Inject constructor(private val detailsRepository: DetailsRepository){
    suspend fun getDetails(id:  String):QuoteDetailsModel{
      return detailsRepository.getQuoteById(id)
    }
}