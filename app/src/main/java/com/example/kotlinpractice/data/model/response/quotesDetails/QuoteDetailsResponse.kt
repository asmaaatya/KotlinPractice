package com.example.kotlinpractice.data.model.response.quotesDetails
data class QuoteDetailsResponse(
    val _id: String,
    val author: String,
    val authorSlug: String,
    val content: String,
    val dateAdded: String,
    val dateModified: String,
    val length: Int,
    val tags: List<String>
) {
    companion object
}