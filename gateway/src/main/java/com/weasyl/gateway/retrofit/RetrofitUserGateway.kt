package com.weasyl.gateway.retrofit

import com.weasyl.domain.entities.UserLogonEntity
import com.weasyl.domain.gateways.UserGateway
import com.weasyl.gateway.Api
import kotlinx.coroutines.Deferred
import retrofit2.Response

class RetrofitUserGateway(
    private val api: Api
) : UserGateway {

    override suspend fun getUserDataAsync(username: String) = api.getUserAsync(username)
    override suspend fun getCurrentUserAsync(): Deferred<Response<UserLogonEntity>> = api.whoAmIAsync()

}