package it.iquii.test.reddit.domain.usecase

import it.iquii.test.reddit.domain.entity.local.FromSimpleToUiImagesMapper
import it.iquii.test.reddit.domain.entity.local.ImagesForUi
import it.iquii.test.reddit.domain.entity.local.SimpleImages
import it.iquii.test.reddit.domain.repository.Repository
import javax.inject.Inject

class PhotoListUsecase @Inject constructor(private val repository: Repository) : UseCase {


    suspend fun retrievePhotosFor(keyword: String): List<ImagesForUi> {
        return repository.fetchImagesFor(keyword).flatMap {simpleImages: SimpleImages? ->
            val list = mutableListOf<ImagesForUi>()
            list.add(FromSimpleToUiImagesMapper().mapFrom(simpleImages!!))
            return list
        }
    }
}