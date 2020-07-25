package it.iquii.test.reddit.library.android.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PhotosMetaDataHolder(val uiIndex: Int = 0, val id: String, val url: String, val author: String, val description: String) : Parcelable