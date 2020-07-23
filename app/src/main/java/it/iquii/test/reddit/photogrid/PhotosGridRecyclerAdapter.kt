package it.iquii.test.reddit.photogrid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import it.iquii.test.reddit.R
import it.iquii.test.reddit.databinding.PhotosItemBinding
import it.iquii.test.reddit.domain.entity.local.ImagesForUi
import java.util.*

class PhotosGridRecyclerAdapter : RecyclerView.Adapter<PhotosGridRecyclerAdapter.GridViewHolder>() {

    private var data: List<ImagesForUi> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        return GridViewHolder(PhotosItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) = holder.bind(data[position])

    fun setData(data: List<ImagesForUi>) {
        this.data = data
        notifyDataSetChanged()
    }

    class GridViewHolder(private val binding: PhotosItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ImagesForUi) = with(itemView) {

            binding.authoreName.text = item.author
            binding.photoImg.load(item.url){
                crossfade(true)
                placeholder(R.drawable.ic_android_black_24dp)
            }

            binding.description.text = item.title

            setOnClickListener {
                // TODO: Handle on click
            }
        }
    }
}