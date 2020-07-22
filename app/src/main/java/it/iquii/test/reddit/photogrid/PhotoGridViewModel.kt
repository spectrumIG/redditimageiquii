package it.iquii.test.reddit.photogrid

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import it.iquii.test.reddit.domain.entity.local.ImagesForUi

class PhotoGridViewModel  @ViewModelInject constructor(): ViewModel() {

    val _photos = MediatorLiveData<List<ImagesForUi>>()

    val photos : LiveData<List<ImagesForUi>>
            get()  = _photos

}