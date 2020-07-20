package it.iquii.test.reddit.domain.entity

import it.iquii.test.reddit.domain.entity.remote.RedditImagesDTO
import it.iquii.test.reddit.library.android.entity.Mapper

/**
 * Simple entity for a generic photo
 * */
data class SimpleImages(val id: String?,val url: String, val title:String,val author: String?)

//data class SimplePreview()


class FromDtoToSimpleImagesMapper :  Mapper<RedditImagesDTO.ExternalData.Children.InnerData,SimpleImages> {
    override fun mapFrom(from: RedditImagesDTO.ExternalData.Children.InnerData): SimpleImages {
        return SimpleImages(from.id,from.url!!,from.title!!,from.author!!)
    }
}