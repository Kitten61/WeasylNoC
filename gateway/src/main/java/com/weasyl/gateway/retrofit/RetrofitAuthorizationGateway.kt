package com.weasyl.gateway.retrofit

import com.weasyl.domain.gateways.AuthorizationGateway
import com.weasyl.domain.models.UserLogonEntity
import com.weasyl.gateway.Api
import io.reactivex.Single

class RetrofitAuthorizationGateway(
    private val api: Api
) : AuthorizationGateway {

    override fun login(apiKey: String): Single<UserLogonEntity> = api.whoAmI(apiKey)



}