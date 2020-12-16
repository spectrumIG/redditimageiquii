package it.subito.test.punkapi.domain.repository.network

import it.subito.test.punkapi.di.RemoteDataStore
import it.subito.test.punkapi.domain.entity.local.FromDtoToSimpleBeerMapper
import it.subito.test.punkapi.domain.entity.local.SimpleBeer
import it.subito.test.punkapi.domain.repository.DataStore
import it.subito.test.punkapi.library.android.entity.Result
import javax.inject.Inject

@RemoteDataStore
class RemoteStore @Inject constructor(private val restApi: RestApi): DataStore {

    suspend fun retrieveImageFor(page: Int?, brewedBefore: String?, brewedAfter: String?): Result<List<SimpleBeer>> {
        val response = restApi.getAllBeersWithPagination(brewedBefore, brewedAfter, page)
        return when {
            response.isSuccessful -> {
                val simpleBeeList = mutableListOf<SimpleBeer>()

                response.body()?.forEach {
                    simpleBeeList.add(FromDtoToSimpleBeerMapper().mapFrom(it))
                }
                return Result.Success(simpleBeeList)
            }

            else -> Result.Error((response as Result.Error).exception)
        }
    }

}