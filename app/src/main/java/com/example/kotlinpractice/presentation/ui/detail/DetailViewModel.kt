package com.example.kotlinpractice.presentation.ui.detail


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinpractice.data.model.request.ResultApiCall
import com.example.kotlinpractice.domain.model.QuoteDetailsModel
import com.example.kotlinpractice.domain.useCases.DetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val detailsUseCase: DetailsUseCase
) : ViewModel() {
    private val _details = MutableStateFlow<ResultApiCall<QuoteDetailsModel>>(ResultApiCall.Loading)
    val details: StateFlow<ResultApiCall<QuoteDetailsModel>> get() = _details

    fun getDetails(id: String) {

        viewModelScope.launch {
            when (val result = detailsUseCase.getDetails(id)) {
                is ResultApiCall.Success -> {
                    _details.emit(result)
                }

                is ResultApiCall.Failure -> {
                    _details.emit(result)
                }

                is ResultApiCall.Loading -> {
                    _details.emit(result)
                }
            }
        }

    }
}