package com.example.kotlinpractice.data.repository.detail


import com.example.kotlinpractice.data.mapper.mapDetailsToUi
import com.example.kotlinpractice.data.model.request.ResultApiCall
import com.example.kotlinpractice.domain.model.QuoteDetailsModel
import com.example.kotlinpractice.data.remote.apis.APiService
import com.example.kotlinpractice.domain.repository.DetailsRepository
import javax.inject.Inject

class DetailsRepositoryImp @Inject constructor(private val apiService: APiService) :
    DetailsRepository {
    override suspend fun getQuoteById(id: String): ResultApiCall<QuoteDetailsModel> {
        return try {
            val details = apiService.getQuoteById(id)
            ResultApiCall.Success(details.mapDetailsToUi())
        } catch (e: Exception) {
            e.printStackTrace()
            ResultApiCall.Failure(e.message ?: "some error occured")
        }
    }
}