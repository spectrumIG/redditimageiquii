package it.iquii.test.reddit.domain.repository.network

import it.iquii.test.reddit.di.RemoteDataStore
import it.iquii.test.reddit.domain.entity.local.SimpleImages
import it.iquii.test.reddit.domain.entity.remote.RedditImagesDTO
import it.iquii.test.reddit.domain.repository.DataStore
import it.iquii.test.reddit.library.android.entity.NetworkResult
import it.iquii.test.reddit.library.android.entity.isValidUrl
import retrofit2.Response
import javax.inject.Inject

@RemoteDataStore
class RemoteStore @Inject constructor(private val restApi: RestApi): DataStore {

    private var after: String = ""
    private var count: String = ""

    suspend fun retrieveImageFor(keyword: String): NetworkResult<List<SimpleImages>> {
        val response = restApi.getImagesFor(keyword)
        return when {
            response.isSuccessful -> {
                val simpleImagesList = mutableListOf<SimpleImages>()


                val externalData = response.body()?.externalData

                if(!externalData?.after.isNullOrBlank()) {
                    after = externalData?.after!!

                }

                externalData?.children?.forEach { children ->

                    if(children?.innerData?.url!!.isValidUrl()) {
                        simpleImagesList.add(
                            SimpleImages(
                                id = children.innerData.id, url = children.innerData.url, title =
                                children.innerData.title!!, author = children.innerData.author!!
                            )
                        )
                    } else if(children.innerData.thumbnail!!.isValidUrl()) {
                        simpleImagesList.add(
                            SimpleImages(
                                id = children.innerData.id, url = children.innerData.thumbnail, title =
                                children.innerData.title!!, author = children.innerData.author!!
                            )
                        )
                    }
                }!!
                count = simpleImagesList.size.toString()
                NetworkResult.Success(simpleImagesList)
            }
            else -> {
                return NetworkResult.Error(NetworkResult.HttpError(Exception(response.message()), response.code()))
            }
        }
    }

    suspend fun retrievePaginatedImageFor(keyword: String): NetworkResult<List<SimpleImages>> {
        val response: Response<RedditImagesDTO> = if(after.isNotBlank() && count.isNotBlank()) {

            restApi.getNextImagesFor(keyword, after, count)
        } else {
            return NetworkResult.Success(emptyList())
        }

        return when {
            response.isSuccessful -> {
                val simpleImagesList = mutableListOf<SimpleImages>()
                val externalData = response.body()?.externalData

                if(!externalData?.after.isNullOrBlank()) {
                    after = externalData?.after!!
                }

                externalData?.children?.forEach { children ->

                    if(children?.innerData?.url!!.isValidUrl()) {
                        simpleImagesList.add(
                            SimpleImages(
                                id = children.innerData.id, url = children.innerData.url, title =
                                children.innerData.title!!, author = children.innerData.author!!
                            )
                        )
                    } else if(children.innerData.thumbnail!!.isValidUrl()) {
                        simpleImagesList.add(
                            SimpleImages(
                                id = children.innerData.id, url = children.innerData.thumbnail, title =
                                children.innerData.title!!, author = children.innerData.author!!
                            )
                        )
                    }
                }!!
                count = simpleImagesList.size.toString()
                NetworkResult.Success(simpleImagesList)
            }
            else -> {
                return NetworkResult.Error(NetworkResult.HttpError(Exception(response.message()), response.code()))
            }
        }
    }

}