package it.iquii.test.reddit.domain.repository.network

import it.iquii.test.reddit.di.RemoteDataStore
import it.iquii.test.reddit.domain.entity.local.SimpleImages
import it.iquii.test.reddit.domain.repository.DataStore
import it.iquii.test.reddit.library.android.entity.DataModel
import it.iquii.test.reddit.library.android.entity.NetworkResult
import javax.inject.Inject

@RemoteDataStore
class RemoteStore @Inject constructor(private val restApi: RestApi): DataStore {

    suspend fun retrieveImageFor(keyword: String): DataModel<List<SimpleImages>> {
        val images = restApi.getImagesFor(keyword)

        if(images.succeded) {
            val data = images as NetworkResult.Success
            val listOfImagesToReturn = data.data.externalData?.children?.flatMap { children ->

                val simpleImagesList = mutableListOf<SimpleImages>()

                simpleImagesList.add(
                    SimpleImages(
                        id = children?.innerData?.id, url = children?.innerData?.url!!, title = children.innerData.title!!,
                        author = children.innerData.author!!
                    )
                )
                simpleImagesList
            }
            return DataModel.SuccessModel(listOfImagesToReturn!!)

        } else {
            return DataModel.SuccessModel(emptyList())
        }
//        if(images.failed){
//            images.onFailure { error ->
//                return DataModel.ErrorModel(
//                    NetworkResult.Error(error).exception.errorCode.toString(), Exception(
//                        NetworkResult.Error(error).exception
//                            .throwable
//                    )
//                )
//            }
//
//        }
    }

}