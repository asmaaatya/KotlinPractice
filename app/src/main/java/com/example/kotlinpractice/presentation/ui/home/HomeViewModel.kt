package com.example.kotlinpractice.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinpractice.data.model.request.ResultApiCall
import com.example.kotlinpractice.domain.model.QuoteModel
import com.example.kotlinpractice.domain.useCases.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: HomeUseCase) : ViewModel() {
    private val _quotes = MutableStateFlow<ResultApiCall<List<QuoteModel>>>(ResultApiCall.Loading)
    val quotes: MutableStateFlow<ResultApiCall<List<QuoteModel>>> get() = _quotes


     fun loadQuotes() {
        viewModelScope.launch {
            when (val result = useCase.getAllQuotes()) {
                is ResultApiCall.Success -> {
                    _quotes.emit(result)
                }

                is ResultApiCall.Failure -> {
                    _quotes.emit(result)
                }

                is ResultApiCall.Loading -> {
                    _quotes.emit(result)
                }

            }


        }
    }
}