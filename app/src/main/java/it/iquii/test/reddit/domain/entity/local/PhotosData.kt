package it.iquii.test.reddit.domain.entity.local

import it.iquii.test.reddit.domain.entity.remote.RedditImagesDTO
import it.iquii.test.reddit.library.android.entity.Mapper

interface PhotosData
/**
 * Simple entity for a generic photo
 * */
data class SimpleImages(val id: String?,val url: String, val title:String,val author: String?) : PhotosData

/**
 * Simple entity for a generic photo for UI layer
 * */
data class ImagesForUi(val id: String?,val url: String,val title: String,val author: String?) : PhotosData

//data class SimplePreview()


/**
 * Mapper for Layer boundaries
 * */
class FromDtoToSimpleImagesMapper :  Mapper<RedditImagesDTO.ExternalData.Children.InnerData, SimpleImages> {
    override fun mapFrom(from: RedditImagesDTO.ExternalData.Children.InnerData): SimpleImages {
        return SimpleImages(from.id, from.url!!, from.title!!, from.author!!)
    }
}
class FromSimpleToUiImagesMapper :  Mapper<SimpleImages,ImagesForUi> {

    override fun mapFrom(from: SimpleImages): ImagesForUi {
        return ImagesForUi(id =from.id, url =from.url, title = from.title, author = from.title)
    }

}
