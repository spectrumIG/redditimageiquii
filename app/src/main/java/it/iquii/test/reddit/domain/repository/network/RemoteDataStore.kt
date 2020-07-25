package it.iquii.test.reddit.domain.repository.network

import it.iquii.test.reddit.di.RemoteDataStore
import it.iquii.test.reddit.domain.entity.local.SimpleImages
import it.iquii.test.reddit.domain.repository.DataStore
import it.iquii.test.reddit.library.android.entity.NetworkResult
import it.iquii.test.reddit.library.android.entity.isValidUrl
import javax.inject.Inject

@RemoteDataStore
class RemoteStore @Inject constructor(private val restApi: RestApi): DataStore {

    suspend fun retrieveImageFor(keyword: String): NetworkResult<List<SimpleImages>> {
        val response = restApi.getImagesFor(keyword)
        if(response.isSuccessful) {
            return NetworkResult.Success(
                response.body()?.externalData?.children?.flatMap { children ->
                    val simpleImagesList = mutableListOf<SimpleImages>()

                    if(children?.innerData?.url!!.isValidUrl()) {
                        simpleImagesList.add(
                            SimpleImages(
                                id = children.innerData.id, url  = children.innerData.url, title =
                                children.innerData.title!!,author = children.innerData.author!!
                            )
                        )
                    }else if(children.innerData.thumbnail!!.isValidUrl()){
                        simpleImagesList.add(
                            SimpleImages(
                                id = children.innerData.id, url  = children.innerData.thumbnail, title =
                                children.innerData.title!!,author = children.innerData.author!!
                            )
                        )

                    }
                    simpleImagesList
                }!!
            )
        } else {
            return NetworkResult.Error(NetworkResult.HttpError(Exception(response.message()), response.code()))
        }

    }

}