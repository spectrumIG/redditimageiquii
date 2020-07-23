package it.iquii.test.reddit.photogrid

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import it.iquii.test.reddit.domain.entity.local.ImagesForUi
import it.iquii.test.reddit.domain.usecase.PhotoListUsecase
import it.iquii.test.reddit.library.android.entity.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class PhotoGridViewModel @ViewModelInject constructor(
    private val usecase: PhotoListUsecase
) : ViewModel() {

    val _photos = MediatorLiveData<Resource<List<ImagesForUi>>>()

    val photos: LiveData<Resource<List<ImagesForUi>>>
        get() = _photos



    fun fetcDataFor(keyword: String) {
        viewModelScope.launch {
            val retrievePhotosFor = usecase.retrievePhotosFor(keyword)
            _photos.postValue(retrievePhotosFor)
        }
    }

}