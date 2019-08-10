package com.thisaay.youtuber.utils.common

data class Resource<out T> private constructor(val status : Status,val data : T) {
    companion object{
        fun<T> success(data: T) : Resource<T> = Resource(Status.SUCCESS,data)
        fun<T> error(data: T) : Resource<T> = Resource(Status.ERROR,data)
        fun<T> unknown(data: T) : Resource<T> = Resource(Status.UNKNOWN,data)
        fun<T> loading(data: T) : Resource<T> = Resource(Status.LOADING,data)

    }
}