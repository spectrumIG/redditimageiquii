package it.subito.test.punkapi.domain.repository.network

import it.subito.test.punkapi.domain.entity.remote.BeersListDTOItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {

    @GET("beers")
    suspend fun getAllBeersWithPagination(
        @Query("brewed_before") before: String? = null,
        @Query("brewed_after") after: String? = null,
        @Query("page")
        page: Int?,
    ):
            Response<List<BeersListDTOItem>>

}