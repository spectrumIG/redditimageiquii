package it.iquii.test.reddit.library.android.entity


/**
 * A generic class that holds  states of data with values and its loading status.
 * @param <T>
 */
sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val exception: HttpError) : Result<Nothing>()


    inline fun onSuccess(action: (T) -> Unit): Result<T> {
        if (this is Success) action(data)
        return this
    }

    inline fun onFailure(action: (HttpError) -> Unit) {
        if(this is Error) action(exception)
    }

    val succeded
        get() = this is Success

    val failed
        get() = this is Error && exception.errorCode != 0

    class HttpError(val throwable: Throwable, val errorCode: Int = 0)

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"        }
    }
}