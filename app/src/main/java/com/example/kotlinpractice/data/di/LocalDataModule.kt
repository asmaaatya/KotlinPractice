package com.example.kotlinpractice.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.example.kotlinpractice.data.local.dataSource.LocalDataStore
import com.example.kotlinpractice.presentation.util.Constants.PREFERENCES_STORE_NAME
import com.example.kotlinpractice.data.local.dataSource.LocalDataStoreImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Singleton
    @Provides
    fun provideLocalDataStore(@ApplicationContext app: Context): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            produceFile = { app.preferencesDataStoreFile(PREFERENCES_STORE_NAME) }
        )
    }

    @Provides
    fun provideApplicationContext(
        @ApplicationContext appContext: Context,
    ): Context {
        return appContext
    }

    @Singleton
    @Provides
    fun provideLocalDataSource(dataStore: DataStore<Preferences>): LocalDataStore {
        return LocalDataStoreImp(dataStore)
    }
}
