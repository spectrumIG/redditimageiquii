package it.subito.test.punkapi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import it.subito.test.punkapi.domain.repository.Repository
import it.subito.test.punkapi.domain.usecase.BeersListUsecase
import it.subito.test.punkapi.domain.usecase.UseCase
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DomainModule {

    @Provides
    @Singleton
    fun provideUseCase(repository: Repository) : UseCase {
        return BeersListUsecase(repository)
    }
}
