package com.example.kotlinpractice.data.repository.home
import com.example.kotlinpractice.data.mapper.mapToQuotesList
import com.example.kotlinpractice.data.model.request.Result
import com.example.kotlinpractice.data.model.response.quotes.QuotesResponse
import com.example.kotlinpractice.data.remote.apis.APiService
import com.example.kotlinpractice.domain.model.QuoteModel
import com.example.kotlinpractice.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImp @Inject constructor(private val apiService: APiService) : HomeRepository {
    override suspend fun getQuotes() :Result<List<QuoteModel>>  {
        return try {
            val quotesResponse: QuotesResponse = apiService.getQuotesList()
           Result.Success(quotesResponse.mapToQuotesList())
        }catch (e:Exception){
            e.printStackTrace()
            Result.Failure(e.message?:"error occured")
        }
    }
}