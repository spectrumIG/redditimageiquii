package it.iquii.test.reddit.photogrid

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import it.iquii.test.reddit.MainActivity
import it.iquii.test.reddit.R
import it.iquii.test.reddit.databinding.PhotoGridFragmentBinding
import it.iquii.test.reddit.library.android.entity.Resource

interface OnFilterListener {
    fun filterSent(keyword: String)
}

@AndroidEntryPoint
//class PhotoGridFragment : BaseFragment(R.layout.photo_grid_fragment), OnFilterListener {
class PhotoGridFragment : Fragment(R.layout.photo_grid_fragment), OnFilterListener {

    private var fragmentBindings: PhotoGridFragmentBinding?  = null
    private val viewModel: PhotoGridViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentBindings = PhotoGridFragmentBinding.bind(view)

        (activity as  MainActivity).listener = this

        val grid = fragmentBindings!!.mainGridRecycler

        val photosGridRecyclerAdapter = PhotosGridRecyclerAdapter()

        grid.apply {
            layoutManager = GridLayoutManager(requireContext(), 4)
            adapter = photosGridRecyclerAdapter
        }
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
                Resource.Status.LOADING -> {
                    fragmentBindings!!.progressBar.visibility = View.VISIBLE
                }
            }

        })
    }

    override fun filterSent(keyword: String) {
        fragmentBindings!!.progressBar.visibility = View.VISIBLE
        viewModel.fetcDataFor(keyword)
    }

    private fun enableErrorMessage() {
        fragmentBindings!!.mainGridRecycler.visibility = View.INVISIBLE
        fragmentBindings!!.noItemText.visibility = View.VISIBLE
        fragmentBindings!!.progressBar.visibility = View.INVISIBLE
    }

    private fun enableGrid() {
        fragmentBindings!!.mainGridRecycler.visibility = View.VISIBLE
        fragmentBindings!!.noItemText.visibility = View.INVISIBLE
        fragmentBindings!!.progressBar.visibility = View.INVISIBLE
    }

    override fun onDestroyView() {
        fragmentBindings = null
        super.onDestroyView()
    }
}

