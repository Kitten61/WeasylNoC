package com.weasyl.gateway

import com.weasyl.domain.models.UserLogonEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header


interface Api {

    @GET("/api/whoami")
    fun whoAmI(@Header("X-Weasyl-API-Key") apiKey: String): Single<UserLogonEntity>

}