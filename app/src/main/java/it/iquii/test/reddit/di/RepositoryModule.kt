package it.iquii.test.reddit.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import it.iquii.test.reddit.domain.repository.DataStore
import it.iquii.test.reddit.domain.repository.Repository
import it.iquii.test.reddit.domain.repository.RepositoryImpl
import it.iquii.test.reddit.domain.repository.network.RemoteStore
import it.iquii.test.reddit.domain.repository.network.RestApi
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
