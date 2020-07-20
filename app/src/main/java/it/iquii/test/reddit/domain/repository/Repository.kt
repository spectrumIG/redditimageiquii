package it.iquii.test.reddit.domain.repository

import it.iquii.test.reddit.di.LocalDataStore
import it.iquii.test.reddit.di.RemoteDataStore
import it.iquii.test.reddit.domain.entity.SimpleImages
import it.iquii.test.reddit.domain.repository.network.RemoteStore
import it.iquii.test.reddit.library.android.entity.Result
import javax.inject.Inject


interface Repository {

    suspend fun fetchImagesFor(keyword: String): List<SimpleImages?>

}

class RepositoryImpl @Inject constructor(
    @LocalDataStore private val localDataStore: DataStore,
    @RemoteDataStore private val remoteDataStore: DataStore
) : Repository {

    override suspend fun fetchImagesFor(keyword: String): List<SimpleImages?> {

//        (remoteDataStore as RemoteStore).retrieveImageFor(keyword)
TODO()
    }

}
