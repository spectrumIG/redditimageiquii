package it.iquii.test.reddit.photogrid

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import it.iquii.test.reddit.BaseFragment
import it.iquii.test.reddit.MainActivity
import it.iquii.test.reddit.R
import it.iquii.test.reddit.databinding.PhotoGridFragmentBinding
import it.iquii.test.reddit.library.android.entity.Resource
import it.iquii.test.reddit.utils.EndlessRecyclerViewScrollListener

interface OnFilterListener {
    fun filterSent(keyword: String)
}

/**
 * Fragmment that manages the Grid Recycler and part of pagination
 *
 * */
@AndroidEntryPoint
class PhotoGridFragment : BaseFragment(R.layout.photo_grid_fragment), OnFilterListener {
    var fragmentBindings: PhotoGridFragmentBinding? = null
    private val viewModel: PhotoGridViewModel by viewModels()
    private var filter: String = ""
    private lateinit var grid: RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentBindings = PhotoGridFragmentBinding.bind(view)

        (activity as MainActivity).listener = this

        grid = fragmentBindings!!.mainGridRecycler

        val photosGridRecyclerAdapter = PhotosGridRecyclerAdapter()

        grid.apply {
            layoutManager = GridLayoutManager(requireContext(), 4)
            adapter = photosGridRecyclerAdapter
        }

        grid.addOnScrollListener(object : EndlessRecyclerViewScrollListener(grid.layoutManager as GridLayoutManager) {

            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                viewModel.fetchPaginatedDataFor(filter)

            }
        })

        viewModel.showProgress.observe(viewLifecycleOwner, Observer { show ->
            if(show) {
                fragmentBindings!!.progressBar.visibility = View.VISIBLE
            } else {
                fragmentBindings!!.progressBar.visibility = View.GONE
            }

        })

        viewModel.photos.observe(viewLifecycleOwner, Observer { resource ->
            when (resource.status) {
                Resource.Status.SUCCESS -> {
                    enableGrid()
                    if(resource.data!!.isEmpty()) {
                        enableErrorMessage()
                    } else {
                        photosGridRecyclerAdapter.setData(resource.data!!)
                    }
                }

                Resource.Status.ERROR -> {
                    enableErrorMessage()
                }

            }
        })
    }


    override fun filterSent(keyword: String) {
        filter = keyword
        (grid.adapter as PhotosGridRecyclerAdapter).clearData()
        viewModel.fetchDataFor(filter)
    }

    private fun enableErrorMessage() {
        fragmentBindings!!.mainGridRecycler.visibility = View.GONE
        fragmentBindings!!.noItemText.visibility = View.VISIBLE
    }

    private fun enableGrid() {
        fragmentBindings!!.mainGridRecycler.visibility = View.VISIBLE
        fragmentBindings!!.noItemText.visibility = View.GONE
    }

    override fun onDestroyView() {
        fragmentBindings = null
        super.onDestroyView()
    }
}

