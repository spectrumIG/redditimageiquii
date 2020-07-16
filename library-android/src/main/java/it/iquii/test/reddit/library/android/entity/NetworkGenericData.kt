package it.iquii.test.reddit.library.android.entity


/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class NetworkResult<out T : Any> {
    data class Success<out T : Any>(val data: T) : NetworkResult<T>()
    data class Error(val exception: Exception) : NetworkResult<Nothing>()
    object Loading : NetworkResult<Nothing>()

    val succeded
        get() = this is Success && data != null

    val failed
        get() = this is Error && exception.message!!.isNotEmpty()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
        }
    }
}