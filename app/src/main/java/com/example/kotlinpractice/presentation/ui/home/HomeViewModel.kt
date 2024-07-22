package com.example.kotlinpractice.presentation.ui.home

import androidx.lifecycle.ViewModel
import com.example.kotlinpractice.domain.repository.HomeRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val homeRepository: HomeRepository): ViewModel() {
    suspend fun getListOfQuotes(){
        homeRepository.getQuotes()
    }
}