package com.example.kotlinpractice.presentation.ui.home


import com.example.kotlinpractice.data.model.request.ResultApiCall
import com.example.kotlinpractice.domain.model.QuoteModel


val dummyQuote = QuoteModel("1", "nice quote", "29-7-2024")

val quoteList = listOf(
    QuoteModel("1", "nice quote1", "29-7-2024"),
    QuoteModel("2", "nice quote2", "30-7-2024"),
    QuoteModel("3", "nice quote3", "1-8-2024"),
)
val successQuotes = ResultApiCall.Success(quoteList)
val failureQuotes = ResultApiCall.Failure("error occurred")
