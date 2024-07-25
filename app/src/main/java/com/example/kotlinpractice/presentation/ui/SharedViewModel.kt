package com.example.kotlinpractice.presentation.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel() : ViewModel() {
    private val _quoteId = MutableLiveData<String>()
    val quoteId: MutableLiveData<String> get() = _quoteId
    fun setQuoteId(id: String) {
        _quoteId.value = id
    }
}