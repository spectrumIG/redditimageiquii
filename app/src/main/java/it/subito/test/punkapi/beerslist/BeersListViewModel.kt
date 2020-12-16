package it.subito.test.punkapi.beerslist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import it.subito.test.punkapi.domain.entity.local.BeerForUi
import it.subito.test.punkapi.domain.usecase.BeersListUsecase
import it.subito.test.punkapi.library.android.entity.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BeersListViewModel @ViewModelInject constructor(
    private val usecase: BeersListUsecase,
) : ViewModel() {

    private val _beers = MutableLiveData<Result<List<BeerForUi>>>()

    val beers: LiveData<Result<List<BeerForUi>>>
        get() = _beers

    private val _showProgress = MutableLiveData<Boolean>(false)

    //TODO: check this one
    val showProgress: LiveData<Boolean>
        get() = _showProgress

    fun fetchBeersPaginatedFor(page: Int) {
        viewModelScope.launch {
            _showProgress.postValue(true)


            _beers.postValue(withContext(Dispatchers.IO) { usecase.retrieveBeersPaginated(page) })

            _showProgress.postValue(false)
        }
    }

    fun fetchBeersPaginatedAndWithFilterDate(page: Int, brewedBefore: String, brewedAfter: String) {
        viewModelScope.launch {
            _showProgress.postValue(true)

            //This is a trick. It's seems that when the data are loaded inside the RecyclerView, it triggers an OnScrolled event even if none is
            // actually done. This is to avoid to chain call endlessly
            when (val retrieveBeersFor = withContext(Dispatchers.IO) { usecase.retrieveBeersPaginatedFor(page, brewedBefore, brewedAfter) }) {
                is Result.Success -> {
                    if(retrieveBeersFor.data.isNotEmpty()) {
                        _beers.postValue(retrieveBeersFor)
//                        _showProgress.postValue(false)
                    }
                }
                else -> {
                    _beers.postValue(retrieveBeersFor)
                }
            }
            _showProgress.postValue(false)

//            if(retrieveBeersFor.data?.size != 0) {
//
//            } else {
//                _showProgress.postValue(false)
//            }
        }
    }


}