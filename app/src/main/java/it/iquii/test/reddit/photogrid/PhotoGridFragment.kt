package it.iquii.test.reddit.photogrid

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import it.iquii.test.reddit.BaseFragment
import it.iquii.test.reddit.R
import it.iquii.test.reddit.databinding.PhotoGridFragmentBinding
import it.iquii.test.reddit.library.android.entity.Resource

@AndroidEntryPoint
class PhotoGridFragment : BaseFragment(R.layout.photo_grid_fragment) {

    private lateinit var fragmentBindings: PhotoGridFragmentBinding
    private val viewModel: PhotoGridViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentBindings = PhotoGridFragmentBinding.bind(view)

        val grid = fragmentBindings.mainGridRecycler

        val photosGridRecyclerAdapter = PhotosGridRecyclerAdapter()
        grid.apply {
            layoutManager = GridLayoutManager(requireContext(), 4)
            adapter = photosGridRecyclerAdapter
        }

        fragmentBindings.button.setOnClickListener {
            viewModel.fetcDataFor(fragmentBindings.searchText.text.toString())
            fragmentBindings.progressBar.visibility = View.VISIBLE
        }

        viewModel.photos.observe(viewLifecycleOwner, Observer { resource ->
            when (resource.status) {
                Resource.Status.SUCCESS -> {

                    photosGridRecyclerAdapter.setData(resource.data!!)
                    fragmentBindings.mainGridRecycler.visibility = View.VISIBLE
                    fragmentBindings.noItemText.visibility = View.INVISIBLE
                    fragmentBindings.progressBar.visibility = View.GONE
                }

                Resource.Status.ERROR ->{
                    fragmentBindings.mainGridRecycler.visibility = View.INVISIBLE
                    fragmentBindings.noItemText.visibility = View.VISIBLE
                }
                    Resource.Status.LOADING -> { fragmentBindings.progressBar.visibility = View.VISIBLE}
            }


        })

    }
}

