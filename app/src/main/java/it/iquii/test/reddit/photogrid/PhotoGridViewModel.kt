package it.iquii.test.reddit.photogrid

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import it.iquii.test.reddit.domain.entity.local.ImagesForUi
import it.iquii.test.reddit.domain.usecase.PhotoListUsecase
import it.iquii.test.reddit.library.android.entity.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PhotoGridViewModel @ViewModelInject constructor(
    private val usecase: PhotoListUsecase
) : ViewModel() {

    val _photos = MutableLiveData<Resource<List<ImagesForUi>>>()

    val photos: LiveData<Resource<List<ImagesForUi>>>
        get() = _photos

    fun fetcDataFor(keyword: String) {
        viewModelScope.launch {
            _photos.postValue(Resource.loading())
            val retrievePhotosFor = withContext(Dispatchers.IO) { usecase.retrievePhotosFor(keyword) }
            _photos.postValue(retrievePhotosFor)
        }
    }

}