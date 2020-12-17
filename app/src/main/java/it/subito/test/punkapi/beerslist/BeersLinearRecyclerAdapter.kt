package it.subito.test.punkapi.beerslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.imageLoader
import coil.load
import it.subito.test.punkapi.R
import it.subito.test.punkapi.databinding.BeerItemBinding
import it.subito.test.punkapi.domain.entity.local.BeerForUi

class BeersLinearRecyclerAdapter :
    RecyclerView.Adapter<BeersLinearRecyclerAdapter.ViewHolder>() {

    private var data: List<BeerForUi> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(BeerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(data[position])

    fun setData(data: List<BeerForUi>) {
        (this.data as ArrayList).addAll(data)
        notifyDataSetChanged()

    }

    fun clearData() {
        (this.data as ArrayList).clear()
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: BeerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: BeerForUi,
        ) {
            with(itemView) {

                binding.photoImg.load(item.imageUrl, context.imageLoader) {
                    crossfade(true)
                    error(R.drawable.ic_download_error)
                    placeholder(R.drawable.ic_beer_mug_empty_svgrepo_com)
                }
                binding.beerName.text = item.name
                binding.beerTagLine.text = item.tagline
                binding.beerFirstBrewd.text = item.date

            }
        }
    }
}