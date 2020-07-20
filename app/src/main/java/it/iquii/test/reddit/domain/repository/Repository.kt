package it.iquii.test.reddit.domain.repository

import it.iquii.test.reddit.domain.entity.SimpleImages
import it.iquii.test.reddit.library.android.entity.NetworkResult


interface Repository {

    suspend fun fetchImagesFor(keyword: String): NetworkResult<List<SimpleImages?>>

}