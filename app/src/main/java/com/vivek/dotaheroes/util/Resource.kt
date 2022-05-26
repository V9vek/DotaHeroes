package com.vivek.dotaheroes.util

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {

    class Success<T>(data: T?) : Resource<T>(data = data)

    class Error<T>(message: String, data: T? = null) : Resource<T>(data = data, message = message)

    class Loading<T>(val isLoading: Boolean = false) : Resource<T>()
}
