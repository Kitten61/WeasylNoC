package com.weasyl.domain.gateways

import com.weasyl.domain.models.UserLogonEntity
import io.reactivex.Single

interface AuthorizationGateway {
    fun login(apiKey: String): Single<UserLogonEntity>
}