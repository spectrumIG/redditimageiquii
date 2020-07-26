package it.iquii.test.reddit.domain.repository.network

import it.iquii.test.reddit.domain.entity.remote.RedditImagesDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RestApi {

    @GET("/r/{keyword}/top.json")
    suspend fun getImagesFor(@Path("keyword") keyword: String): Response<RedditImagesDTO>

    @GET("/r/{keyword}/top.json")
    suspend fun getNextImagesFor(
        @Path("keyword") keyword: String,
        @Query("afterLink") afterLink: String,
        @Query("numberOfActualItems") numberCount: String
    ): Response<RedditImagesDTO>

}