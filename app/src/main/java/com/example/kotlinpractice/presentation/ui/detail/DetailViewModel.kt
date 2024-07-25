package com.example.kotlinpractice.presentation.ui.detail


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinpractice.data.model.beans.QuoteDetailsModel
import com.example.kotlinpractice.domain.useCases.DetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val detailsUseCase: DetailsUseCase
) : ViewModel() {
    private val _details=MutableLiveData<QuoteDetailsModel>()
    val details:MutableLiveData<QuoteDetailsModel> get() =_details

    fun getDetails(id:String){
        viewModelScope.launch {
            try {
                _details.value=detailsUseCase.getDetails(id)
            }catch (e:Exception){
                e.printStackTrace()
            }
        }

    }
}