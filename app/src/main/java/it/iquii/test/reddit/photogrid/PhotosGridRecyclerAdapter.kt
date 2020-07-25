package it.iquii.test.reddit.photogrid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.size.Scale
import it.iquii.test.reddit.R
import it.iquii.test.reddit.databinding.PhotosItemBinding
import it.iquii.test.reddit.domain.entity.local.ImagesForUi
import it.iquii.test.reddit.library.android.entity.PhotosMetaDataHolder
import java.util.*

class PhotosGridRecyclerAdapter : RecyclerView.Adapter<PhotosGridRecyclerAdapter.GridViewHolder>() {

    private var data: List<ImagesForUi> = ArrayList()
    var metaData: List<PhotosMetaDataHolder> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        return GridViewHolder(PhotosItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) = holder.bind(data[position],position,metaData)

    fun setData(data: List<ImagesForUi>) {
        this.data = data
        notifyDataSetChanged()
        metaData = this.data.map {element ->
            PhotosMetaDataHolder(uiIndex = 0,
                id = element.id!!,
                url = element.url,
                author = element.author!!,
                description = element.title)
        }

    }

    class GridViewHolder(private val binding: PhotosItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: ImagesForUi,
            index: Int,
            metaData: List<PhotosMetaDataHolder>
        ) = with(itemView) {

            binding.photoImg.load(item.url){
                scale(Scale.FILL)
                crossfade(true)
                error(R.drawable.ic_download_error)
                placeholder(R.drawable.ic_android_black_24dp)
            }

            setOnClickListener {

               val args  = Bundle()
                args.putInt("index",index)
                args.putParcelableArray("photosArray",metaData.toTypedArray())
                findNavController().navigate(R.id.toDetailSwipeFragment,args)

            }
        }
    }
}