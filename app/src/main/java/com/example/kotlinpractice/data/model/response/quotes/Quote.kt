package com.example.kotlinpractice.data.model.response.quotes
// todo 1- we should add some models here
data class Quote(
    val _id: String,
    val author: String,
    val authorSlug: String,
    val content: String,
    val dateAdded: String,
    val dateModified: String,
    val length: Int,
    val tags: List<String>
)