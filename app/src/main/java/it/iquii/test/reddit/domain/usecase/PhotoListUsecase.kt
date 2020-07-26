package it.iquii.test.reddit.domain.usecase

import it.iquii.test.reddit.domain.entity.local.FromSimpleToUiImagesMapper
import it.iquii.test.reddit.domain.entity.local.ImagesForUi
import it.iquii.test.reddit.domain.entity.local.SimpleImages
import it.iquii.test.reddit.domain.repository.Repository
import it.iquii.test.reddit.library.android.entity.Resource
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