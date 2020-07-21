package it.iquii.test.reddit.domain.repository

import it.iquii.test.reddit.di.LocalDataStore
import it.iquii.test.reddit.di.RemoteDataStore
import it.iquii.test.reddit.domain.entity.local.SimpleImages
import it.iquii.test.reddit.domain.repository.network.RemoteStore
import it.iquii.test.reddit.library.android.entity.DataModel
import javax.inject.Inject


interface Repository {

    suspend fun fetchImagesFor(keyword: String): List<SimpleImages?>

}

/**
 * Main entry point for Single-source-of-truth pattern.
 *
 * */

class RepositoryImpl @Inject constructor(
    @LocalDataStore private val localDataStore: DataStore,
    @RemoteDataStore private val remoteDataStore: DataStore
) : Repository {

    /**
     * */
    override suspend fun fetchImagesFor(keyword: String): List<SimpleImages?> {

//TODO: check this type. They are wrong
        return ((remoteDataStore as RemoteStore).retrieveImageFor(keyword) as DataModel.SuccessModel).model

    }

}
