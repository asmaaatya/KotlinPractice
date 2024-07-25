package com.example.kotlinpractice.domain.useCases

import com.example.kotlinpractice.data.model.beans.QuoteModel
import com.example.kotlinpractice.domain.repository.HomeRepository
import javax.inject.Inject

class HomeUseCase @Inject constructor(private val homeRepository:HomeRepository) {
    suspend fun getAllQuotes():List<QuoteModel>{
      return homeRepository.getQuotes()
    }
}