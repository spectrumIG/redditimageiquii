package it.subito.test.punkapi.beerslist

import androidx.recyclerview.widget.RecyclerView
import it.subito.test.punkapi.beerslist.uimodel.UiInfoHolder
import it.subito.test.punkapi.utils.EndlessRecyclerViewScrollListener

class BeersEndelessList(
    layoutManager: RecyclerView.LayoutManager?,
    private val viewModel: BeersListViewModel,
    private val dataHolder: UiInfoHolder,
) : EndlessRecyclerViewScrollListener(layoutManager) {

    override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
        if(dataHolder.showFiltered) {
            viewModel.fetchBeersPaginatedAndWithFilterDate(page, dataHolder.brewedBefore, dataHolder.brewedAfter)
        } else {
            viewModel.fetchBeersPaginatedFor(page)
        }
    }
}