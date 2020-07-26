package it.iquii.test.reddit.domain.repository

import it.iquii.test.reddit.di.RemoteDataStore
import it.iquii.test.reddit.domain.entity.local.SimpleImages
import it.iquii.test.reddit.domain.repository.network.RemoteStore
import it.iquii.test.reddit.library.android.entity.NetworkResult
import it.iquii.test.reddit.library.android.entity.Resource
import javax.inject.Inject


interface Repository {

    suspend fun fetchImagesFor(keyword: String): Resource<List<SimpleImages?>>

    suspend fun fetchPaginatedImagesFor(keyword: String): Resource<List<SimpleImages?>>
}

/**
 * Main entry point for Single-source-of-truth pattern.
 * TODO: Adds Local data store for caching
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
