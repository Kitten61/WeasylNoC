package com.weasyl.domain.gateways

import com.weasyl.domain.entities.UserEntity
import com.weasyl.domain.entities.UserLogonEntity
import kotlinx.coroutines.Deferred
import retrofit2.Response

interface UserGateway {

    suspend fun getUserDataAsync(username: String) : Deferred<Response<UserEntity>>

    suspend fun getCurrentUserAsync() : Deferred<Response<UserLogonEntity>>

    suspend fun getUserId(username: String?): Int

}