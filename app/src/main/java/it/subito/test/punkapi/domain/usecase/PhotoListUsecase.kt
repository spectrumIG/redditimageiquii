package it.subito.test.punkapi.domain.usecase

import it.subito.test.punkapi.domain.entity.local.FromSimpleToUiImagesMapper
import it.subito.test.punkapi.domain.entity.local.ImagesForUi
import it.subito.test.punkapi.domain.entity.local.SimpleImages
import it.subito.test.punkapi.domain.repository.Repository
import it.subito.test.punkapi.library.android.entity.Resource
import javax.inject.Inject

class PhotoListUsecase @Inject constructor(private val repository: Repository) : UseCase {


    suspend fun retrievePhotosFor(keyword: String): Resource<List<ImagesForUi>> {

        val fetchImagesFor = repository.fetchImagesFor(keyword)
        return when (fetchImagesFor.status) {
            Resource.Status.SUCCESS -> {
                val list = fetchImagesFor.data!!.map { simpleImage: SimpleImages? ->
                    FromSimpleToUiImagesMapper().mapFrom(simpleImage!!)
                }
                Resource.success(list)

            }
            Resource.Status.ERROR -> {
                Resource.error(fetchImagesFor.message!!)
            }

        }

    }

    suspend fun retrievePaginatedPhotosFor(keyword: String): Resource<List<ImagesForUi>> {

        val fetchImagesFor = repository.fetchPaginatedImagesFor(keyword)

        return when (fetchImagesFor.status) {
            Resource.Status.SUCCESS -> {
                val list = fetchImagesFor.data!!.map { simpleImage: SimpleImages? ->
                    FromSimpleToUiImagesMapper().mapFrom(simpleImage!!)
                }
                Resource.success(list)

            }
            Resource.Status.ERROR -> {
                Resource.error(fetchImagesFor.message!!)
            }

        }

    }
}