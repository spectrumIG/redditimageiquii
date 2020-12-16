package it.subito.test.punkapi.domain.repository

import it.subito.test.punkapi.di.RemoteDataStore
import it.subito.test.punkapi.domain.entity.local.SimpleBeer
import it.subito.test.punkapi.domain.repository.network.RemoteStore
import it.subito.test.punkapi.library.android.entity.Result
import javax.inject.Inject


interface Repository {

    suspend fun fetchAllBeerPaginated(page: Int): Result<List<SimpleBeer?>>

    suspend fun fetchPaginatedBeersForDate(page: Int, brewedBefore: String, brewedAfter: String): Result<List<SimpleBeer?>>
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
    override suspend fun fetchAllBeerPaginated(page: Int): Result<List<SimpleBeer?>> {

        return remoteDataStore.retrieveImageFor(page = page, null, null)
    }

    /**
     * */
    override suspend fun fetchPaginatedBeersForDate(page: Int, brewedBefore: String, brewedAfter: String): Result<List<SimpleBeer?>> {

        return remoteDataStore.retrieveImageFor(page = page, brewedBefore = brewedBefore, brewedAfter = brewedAfter)
    }

}
