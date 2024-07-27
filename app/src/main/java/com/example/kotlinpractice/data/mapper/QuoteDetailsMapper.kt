package com.example.kotlinpractice.data.mapper

import com.example.kotlinpractice.domain.model.QuoteDetailsModel
import com.example.kotlinpractice.data.model.response.quotesDetails.QuoteDetailsResponse

fun QuoteDetailsResponse.mapDetailsToUi(): QuoteDetailsModel {
    return QuoteDetailsModel(
        author = author,
        tags = tags
    )
}