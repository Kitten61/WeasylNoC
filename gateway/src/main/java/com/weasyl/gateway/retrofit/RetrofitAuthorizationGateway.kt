package com.weasyl.gateway.retrofit

import com.weasyl.domain.gateways.AuthorizationGateway
import com.weasyl.domain.entities.UserLogonEntity
import com.weasyl.gateway.Api
import retrofit2.Response

class RetrofitAuthorizationGateway(
    private val api: Api
) : AuthorizationGateway {

    override suspend fun login(): Response<UserLogonEntity> {
        val result = api.whoAmIAsync().await()
        return result
    }

}