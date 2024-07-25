package com.example.kotlinpractice.data.mapper

import com.example.kotlinpractice.data.model.beans.QuoteDetailsModel
import com.example.kotlinpractice.data.model.response.quotesDetails.QuoteDetailsResponse

object QuoteDetailsMapper {
    fun mapDetailsToUi(quoteDetailsResponse: QuoteDetailsResponse):QuoteDetailsModel{
        return QuoteDetailsModel(
            author = quoteDetailsResponse.author,
            tags = quoteDetailsResponse.tags
        )
    }
}