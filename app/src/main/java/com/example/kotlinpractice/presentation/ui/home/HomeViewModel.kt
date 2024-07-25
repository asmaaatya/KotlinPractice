package com.example.kotlinpractice.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinpractice.data.model.beans.QuoteModel
import com.example.kotlinpractice.domain.useCases.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: HomeUseCase): ViewModel() {
    private val _quotes = MutableLiveData<List<QuoteModel>>()
    val quotes: LiveData<List<QuoteModel>> get() = _quotes

    fun loadQuotes() {
        viewModelScope.launch {
            try {
                _quotes.value = useCase.getAllQuotes()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}