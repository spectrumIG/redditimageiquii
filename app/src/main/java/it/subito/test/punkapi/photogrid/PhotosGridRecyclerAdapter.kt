package it.subito.test.punkapi.photogrid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.size.Scale
import it.subito.test.punkapi.R
import it.subito.test.punkapi.databinding.PhotosItemBinding
import it.subito.test.punkapi.domain.entity.local.ImagesForUi
import it.subito.test.punkapi.library.android.entity.PhotosMetaDataHolder

class PhotosGridRecyclerAdapter : RecyclerView.Adapter<PhotosGridRecyclerAdapter.GridViewHolder>() {

    private var data: List<ImagesForUi> = ArrayList()
    var metaData: List<PhotosMetaDataHolder> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        return GridViewHolder(PhotosItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) = holder.bind(data[position],position,metaData)

    fun setData(data: List<ImagesForUi>) {
        (this.data as ArrayList).addAll(data)
        notifyDataSetChanged()
        metaData = this.data.map { element ->
            PhotosMetaDataHolder(
                uiIndex = 0,
                id = element.id!!,
                url = element.url,
                author = element.author!!,
                description = element.title
            )
        }

    }


    fun clearData() {
        (this.data as ArrayList).clear()
        notifyDataSetChanged()
    }

    class GridViewHolder(private val binding: PhotosItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: ImagesForUi,
            index: Int,
            metaData: List<PhotosMetaDataHolder>
        ) = with(itemView) {

            binding.photoImg.load(item.url) {
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