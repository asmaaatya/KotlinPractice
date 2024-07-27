package com.example.kotlinpractice.data.model.request


sealed class Result<out T> {
    data class Success<out s>(val data: s) : Result<s>()
    data class Failure(val message: String) : Result<Nothing>()
    data object Loading : Result<Nothing>()
}