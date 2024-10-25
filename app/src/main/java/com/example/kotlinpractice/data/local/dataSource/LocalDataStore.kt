package com.example.kotlinpractice.data.local.dataSource

import kotlinx.coroutines.flow.Flow

interface LocalDataStore {

    suspend fun saveToken(accessToken: String)
    suspend fun saveLanguage(language: String)

    suspend fun requestToken(): Flow<String?>
    suspend fun requestLanguage(): Flow<String?>

    suspend fun clearToken()
}