package com.example.kotlinpractice.data.mapper

import com.example.kotlinpractice.domain.model.QuoteModel
import com.example.kotlinpractice.data.model.response.quotes.Quote
import com.example.kotlinpractice.data.model.response.quotes.QuotesResponse


fun QuotesResponse.mapToQuotesList(): List<QuoteModel> {
    return this.results.map { it.mapToQuotesModel() }
}

fun Quote.mapToQuotesModel(): QuoteModel {
    return QuoteModel(
        _id = this._id,
        content = this.content,
        dateAdded = this.dateAdded,
    )
}
