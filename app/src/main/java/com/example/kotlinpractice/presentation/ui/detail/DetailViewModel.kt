package com.example.kotlinpractice.presentation.ui.detail

import androidx.lifecycle.ViewModel
import com.example.kotlinpractice.domain.repository.DetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val detailsRepository: DetailsRepository
// todo 7- we should add some logic for the viewModel
) : ViewModel() {
    suspend fun getDetails(){
        detailsRepository.getQuoteById("")
    }
}