package com.weasyl.domain.enums

sealed class RetrofitState {
    data class OK<T>(val body: T) : RetrofitState()
    object Unauthorized : RetrofitState()
    object ClientError : RetrofitState()
}