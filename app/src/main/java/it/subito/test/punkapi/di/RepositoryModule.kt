package it.subito.test.punkapi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import it.subito.test.punkapi.domain.repository.DataStore
import it.subito.test.punkapi.domain.repository.Repository
import it.subito.test.punkapi.domain.repository.RepositoryImpl
import it.subito.test.punkapi.domain.repository.network.RemoteStore
import it.subito.test.punkapi.domain.repository.network.RestApi
import javax.inject.Qualifier
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {


    @Provides
    @Singleton
    fun provideRepository(@RemoteDataStore remoteStore: DataStore) : Repository{
        return RepositoryImpl(remoteStore as RemoteStore)
    }


    @Provides
    @LocalDataStore
    fun providesLocalDataStore(): DataStore {
        TODO()
    }


    @Provides
    @RemoteDataStore
    fun providesRemoteDataStore(restApi: RestApi): DataStore {
        return RemoteStore(restApi)
    }


}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class LocalDataStore

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class RemoteDataStore
