package com.example.kotlinpractice.data.di

import com.example.kotlinpractice.data.repository.detail.DetailsRepositoryImp
import com.example.kotlinpractice.data.repository.home.HomeRepositoryImp
import com.example.kotlinpractice.domain.repository.DetailsRepository
import com.example.kotlinpractice.domain.repository.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDetailsRepository(
        detailsRepositoryImpl: DetailsRepositoryImp
    ): DetailsRepository {
        return detailsRepositoryImpl
    }

    @Provides
    @Singleton
    fun provideHomeRepository(
        homeRepositoryImp: HomeRepositoryImp
    ): HomeRepository {
        return homeRepositoryImp
    }
}

