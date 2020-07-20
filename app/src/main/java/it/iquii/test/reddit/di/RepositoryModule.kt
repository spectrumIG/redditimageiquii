package it.iquii.test.reddit.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import it.iquii.test.reddit.domain.repository.DataStore
import it.iquii.test.reddit.domain.repository.network.RemoteStore
import it.iquii.test.reddit.domain.repository.network.RestApi
import javax.inject.Qualifier


@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

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
@Retention(AnnotationRetention.BINARY)
annotation class LocalDataStore

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RemoteDataStore
