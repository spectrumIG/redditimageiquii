package it.subito.test.punkapi.beerslist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import it.subito.test.punkapi.beerslist.uimodel.UiInfoHolder
import it.subito.test.punkapi.domain.entity.local.BeerForUi
import it.subito.test.punkapi.domain.usecase.BeersListUsecase
import it.subito.test.punkapi.domain.usecase.UseCase
import it.subito.test.punkapi.library.android.entity.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BeersListViewModel @ViewModelInject constructor(
    private val usecase: UseCase,
) : ViewModel() {

    private val _beers = MutableLiveData<Result<List<BeerForUi>>>()
    val beers: LiveData<Result<List<BeerForUi>>>
        get() = _beers

    private val _showProgress = MutableLiveData(false)
    val showProgress: LiveData<Boolean>
        get() = _showProgress

    private val _uiDataForFilter = MutableLiveData<UiInfoHolder>()

    val uiDataForFilter: LiveData<UiInfoHolder>
        get() = _uiDataForFilter

    fun fetchBeersPaginatedFor(page: Int) {
        val beersListUsecase = usecase as BeersListUsecase

        viewModelScope.launch {
            _showProgress.postValue(true)


            _beers.postValue(withContext(Dispatchers.IO) { beersListUsecase.retrieveBeersPaginated(page) })

            _showProgress.postValue(false)
        }
    }

    fun fetchBeersPaginatedAndWithFilterDate(page: Int, brewedBefore: String?, brewedAfter: String?) {
        val beersListUsecase = usecase as BeersListUsecase
        viewModelScope.launch {
            _showProgress.postValue(true)
            when (val retrieveBeersFor =
                withContext(Dispatchers.IO) { beersListUsecase.retrieveBeersPaginatedFor(page, brewedBefore, brewedAfter) }) {
                is Result.Success -> {
                    if(retrieveBeersFor.data.isNotEmpty()) {
                        _beers.postValue(retrieveBeersFor)
                        _uiDataForFilter.value = UiInfoHolder(true, page = 1, brewedAfter = brewedAfter, brewedBefore = brewedBefore)
                        _showProgress.postValue(false)
                    }
                }
                else -> {
                    _beers.postValue(retrieveBeersFor)
                }
            }
            _showProgress.postValue(false)

        }
    }


}