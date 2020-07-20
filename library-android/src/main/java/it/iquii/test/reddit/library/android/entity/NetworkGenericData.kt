package it.iquii.test.reddit.library.android.entity


/**
 * A generic class that holds network states of data with values and its loading status.
 * @param <T>
 */
sealed class NetworkResult<out T : Any> {
    data class Success<out T : Any>(val data: T) : NetworkResult<T>()
    data class Error(val exception: HttpError) : NetworkResult<Nothing>()
    object Loading : NetworkResult<Nothing>()

    val succeded
        get() = this is Success

    val failed
        get() = this is Error && exception.errorCode != 0

    class HttpError(val throwable: Throwable, val errorCode: Int = 0)

    inline fun <T : Any> NetworkResult<T>.onSuccess(action: (T) -> Unit): NetworkResult<T> {
        if (this is Success) action(data)
        return this
    }

    inline fun onFailure(action: (HttpError) -> Unit) {
        if(this is Error) action(exception)
    }

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
        }
    }
}