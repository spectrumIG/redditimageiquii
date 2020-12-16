package it.subito.test.punkapi.beerslist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import it.subito.test.punkapi.BaseFragment
import it.subito.test.punkapi.R
import it.subito.test.punkapi.databinding.BeersListFragmentBinding
import it.subito.test.punkapi.library.android.entity.Result
import it.subito.test.punkapi.utils.EndlessRecyclerViewScrollListener

interface OnFilterListener {
    fun filterSent(keyword: String)
}

/**
 * Fragmment that manages the Grid Recycler and part of pagination
 *
 * */
@AndroidEntryPoint
class BeersListFragment : BaseFragment(R.layout.beers_list_fragment) {
    var fragmentBindings: BeersListFragmentBinding? = null
    private val viewModel: BeersListViewModel by viewModels()
    private var filter: String = ""
    private lateinit var recyclerView: RecyclerView
    private var page = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        fragmentBindings = BeersListFragmentBinding.bind(view)

        recyclerView = fragmentBindings!!.mainBeersRecycler

        val beersListAdapter = BeersLinearRecyclerAdapter()

        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = beersListAdapter
        }
        viewModel.fetchBeersPaginatedFor(page)

        recyclerView.addOnScrollListener(object : EndlessRecyclerViewScrollListener(recyclerView.layoutManager) {

            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                viewModel.fetchBeersPaginatedFor(page)

            }
        })

        viewModel.showProgress.observe(viewLifecycleOwner) { show ->
            if(show) {
                fragmentBindings!!.progressBar.visibility = View.VISIBLE
            } else {
                fragmentBindings!!.progressBar.visibility = View.GONE
            }

        }

        viewModel.beers.observe(viewLifecycleOwner) { resource ->


            when (resource) {
                is Result.Success -> {
                    enableList()
                    if(resource.data.isEmpty()) {
                        enableErrorMessage()
                    } else {
                        beersListAdapter.setData(resource.data)
                    }
                }

                is Result.Error -> {
                    enableErrorMessage()
                }

            }
        }
    }


//    override fun filterSent(keyword: String) {
//        filter = keyword
//        (recyclerView.adapter as BeersLinearRecyclerAdapter).clearData()
//        viewModel.fetchBeersPaginatedFor(filter)
//    }

    private fun enableErrorMessage() {
        fragmentBindings!!.mainBeersRecycler.visibility = View.GONE
        fragmentBindings!!.noItemText.visibility = View.VISIBLE
    }

    private fun enableList() {
        fragmentBindings!!.mainBeersRecycler.visibility = View.VISIBLE
        fragmentBindings!!.noItemText.visibility = View.GONE
    }

    override fun onDestroyView() {
        fragmentBindings = null
        super.onDestroyView()
    }
}

