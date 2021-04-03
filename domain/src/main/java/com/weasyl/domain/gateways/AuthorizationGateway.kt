package com.weasyl.domain.gateways

import com.weasyl.domain.entities.UserLogonEntity
import retrofit2.Response

interface AuthorizationGateway {
    suspend fun login(): Response<UserLogonEntity>
}