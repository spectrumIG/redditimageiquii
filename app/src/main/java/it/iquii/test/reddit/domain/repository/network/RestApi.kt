package it.iquii.test.reddit.domain.repository.network

import it.iquii.test.reddit.domain.entity.remote.RedditImagesDTO
import it.iquii.test.reddit.library.android.entity.NetworkResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RestApi {

    @GET("/r/{keyword}/top.json")
    suspend fun getImagesFor(@Path("keyword") keyword:String) : Response<RedditImagesDTO>

}