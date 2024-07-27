package com.example.kotlinpractice.presentation.ui.detail


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinpractice.data.model.request.Result
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
    private val _details = MutableStateFlow<Result<QuoteDetailsModel>>(Result.Loading)
    val details: StateFlow<Result<QuoteDetailsModel>> get() = _details

    fun getDetails(id: String) {

        viewModelScope.launch {
            when (val result = detailsUseCase.getDetails(id)) {
                is Result.Success -> {
                    _details.emit(result)
                }

                is Result.Failure -> {
                    _details.emit(result)
                }

                is Result.Loading -> {
                    _details.emit(result)
                }
            }
        }

    }
}