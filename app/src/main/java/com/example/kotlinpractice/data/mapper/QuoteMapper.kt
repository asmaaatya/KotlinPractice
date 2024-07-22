package com.example.kotlinpractice.data.mapper

import com.example.kotlinpractice.data.model.beans.QuoteModel
import com.example.kotlinpractice.data.model.response.quotes.Quote
import com.example.kotlinpractice.data.model.response.quotes.QuotesResponse

// todo 7- we should add some map for the objects
object QuoteMapper{
    fun mapToUiModel(quote: Quote): QuoteModel {
        return QuoteModel(
            _id = quote._id,
            content = quote.content,
            dateAdded = quote.dateAdded,
        )
    }

    fun mapToUiModelList(quotesResponse: QuotesResponse): List<QuoteModel> {
        return quotesResponse.results.map { mapToUiModel(it) }
    }
}