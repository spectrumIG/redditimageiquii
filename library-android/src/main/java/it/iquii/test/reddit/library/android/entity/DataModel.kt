package it.iquii.test.reddit.library.android.entity


sealed class DataModel<out T : Any> {
    data class SuccessModel<out T : Any>(val model: T) : DataModel<T>()
    data class ErrorModel(val error: String, val exception: Exception) : DataModel<Nothing>()
}