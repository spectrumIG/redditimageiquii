package it.subito.test.punkapi.domain.repository

import it.subito.test.punkapi.di.RemoteDataStore
import it.subito.test.punkapi.domain.entity.local.SimpleImages
import it.subito.test.punkapi.domain.repository.network.RemoteStore
import it.subito.test.punkapi.library.android.entity.NetworkResult
import it.subito.test.punkapi.library.android.entity.Resource
import javax.inject.Inject


interface Repository {

    suspend fun fetchImagesFor(keyword: String): Resource<List<SimpleImages?>>

    suspend fun fetchPaginatedImagesFor(keyword: String): Resource<List<SimpleImages?>>
}

/**
 * Main entry point for Single-source-of-truth pattern.
 * Should contain Local data store but for sake of simplicity and time
 * i'm gonna use just the remote
 * */

class RepositoryImpl @Inject constructor(
    @RemoteDataStore private val remoteDataStore: RemoteStore
) : Repository {

    /**
     * */
    override suspend fun fetchImagesFor(keyword: String): Resource<List<SimpleImages?>> {

        return when (val retrieveImageFor = remoteDataStore.retrieveImageFor(keyword)) {
            is NetworkResult.Success -> {
                Resource.success(retrieveImageFor.data)
            }
            is NetworkResult.Error -> {
                Resource.error(retrieveImageFor.exception.throwable.message!!)
            }
        }
    }

    /**
     * */
    override suspend fun fetchPaginatedImagesFor(keyword: String): Resource<List<SimpleImages?>> {

        return when (val retrieveImageFor = remoteDataStore.retrievePaginatedImageFor(keyword)) {
            is NetworkResult.Success -> {
                Resource.success(retrieveImageFor.data)
            }
            is NetworkResult.Error -> {
                Resource.error(retrieveImageFor.exception.throwable.message!!)
            }
        }
    }

}
