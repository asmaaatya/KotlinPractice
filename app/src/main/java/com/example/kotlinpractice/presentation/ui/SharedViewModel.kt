package com.example.kotlinpractice.presentation.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.runBlocking

class SharedViewModel() : ViewModel() {
    private val _quoteId = MutableStateFlow<String?>(null)

    val quoteId: StateFlow<String?> get() = _quoteId
    fun setQuoteId(id: String) = runBlocking {
        Log.d("set id", id)
        _quoteId.emit(id) }
}