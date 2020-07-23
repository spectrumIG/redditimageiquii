package it.iquii.test.reddit.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import it.iquii.test.reddit.domain.repository.Repository
import it.iquii.test.reddit.domain.usecase.PhotoListUsecase
import it.iquii.test.reddit.domain.usecase.UseCase
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DomainModule {

    @Provides
    @Singleton
    fun provideUseCase(repository: Repository) : UseCase {
        return PhotoListUsecase(repository)
    }
}
