package it.iquii.test.reddit.domain.repository.network

import it.iquii.test.reddit.di.RemoteDataStore
import it.iquii.test.reddit.domain.entity.SimpleImages
import it.iquii.test.reddit.domain.repository.DataStore
import it.iquii.test.reddit.library.android.entity.Result
import javax.inject.Inject

@RemoteDataStore
class RemoteStore @Inject constructor(private val restApi: RestApi): DataStore {

   suspend fun retrieveImageFor(keyword: String): List<SimpleImages> {
        val imagesFor = restApi.getImagesFor(keyword)

       if(imagesFor.succeded){
           imagesFor.onSuccess {

           }
       }
TODO()
    }

}