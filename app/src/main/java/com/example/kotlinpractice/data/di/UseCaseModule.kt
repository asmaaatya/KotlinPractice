package com.example.kotlinpractice.data.di
import com.example.kotlinpractice.domain.repository.DetailsRepository
import com.example.kotlinpractice.domain.repository.HomeRepository
import com.example.kotlinpractice.domain.useCases.DetailsUseCase
import com.example.kotlinpractice.domain.useCases.HomeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideHomeUseCase(
       homeRepository: HomeRepository
    ): HomeUseCase {
        return HomeUseCase(homeRepository)
    }
    @Provides
    @Singleton
    fun provideDetailsUseCase(
        detailsRepository: DetailsRepository
    ): DetailsUseCase {
        return DetailsUseCase(detailsRepository)
    }
}