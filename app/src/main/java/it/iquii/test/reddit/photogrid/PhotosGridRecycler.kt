package it.iquii.test.reddit.photogrid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import it.iquii.test.reddit.databinding.PhotosItemBinding
import it.iquii.test.reddit.domain.entity.local.ImagesForUi
import java.util.*

class PhotosGridRecycler : RecyclerView.Adapter<PhotosGridRecycler.GridViewHolder>() {

    private var data: List<ImagesForUi> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        return GridViewHolder(PhotosItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) = holder.bind(data[position])

    fun swapData(data: List<ImagesForUi>) {
        this.data = data
        notifyDataSetChanged()
    }

    class GridViewHolder(private val binding: PhotosItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ImagesForUi) = with(itemView) {
            // TODO: Bind the data with View
            setOnClickListener {
                // TODO: Handle on click
            }
        }
    }
}