package it.subito.test.punkapi.photogrid

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import it.subito.test.punkapi.domain.entity.local.ImagesForUi
import it.subito.test.punkapi.domain.usecase.PhotoListUsecase
import it.subito.test.punkapi.library.android.entity.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PhotoGridViewModel @ViewModelInject constructor(
    private val usecase: PhotoListUsecase
) : ViewModel() {

    private val _photos = MutableLiveData<Resource<List<ImagesForUi>>>()

    val photos: LiveData<Resource<List<ImagesForUi>>>
        get() = _photos

    private val _showProgress = MutableLiveData<Boolean>(false)

    val showProgress: LiveData<Boolean>
        get() = _showProgress

    fun fetchDataFor(keyword: String) {
        viewModelScope.launch {
            _showProgress.postValue(true)
            val retrievePhotosFor = withContext(Dispatchers.IO) { usecase.retrievePhotosFor(keyword) }
            _photos.postValue(retrievePhotosFor)
            _showProgress.postValue(false)
        }
    }

    fun fetchPaginatedDataFor(keyword: String) {
        viewModelScope.launch {
            _showProgress.postValue(true)
            val retrievePhotosFor = withContext(Dispatchers.IO) { usecase.retrievePaginatedPhotosFor(keyword) }
            //This is a trick. It's seems that when the data are loaded inside the RecyclerView, it triggers an OnScrolled event even if none is
            // actually done. This is to avoid to chain call endlessly
            if(retrievePhotosFor.data?.size != 0) {
                _photos.postValue(retrievePhotosFor)
                _showProgress.postValue(false)
            } else {
                _showProgress.postValue(false)
            }
        }
    }


}