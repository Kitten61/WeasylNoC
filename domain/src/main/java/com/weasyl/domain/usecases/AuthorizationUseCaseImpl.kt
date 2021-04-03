package com.weasyl.domain.usecases

import com.weasyl.domain.constants.HttpStatusCodes
import com.weasyl.domain.enums.RetrofitState
import com.weasyl.domain.enums.RetrofitState.*
import com.weasyl.domain.gateways.AuthorizationGateway
import com.weasyl.domain.usecases.authorization.AuthorizationUseCase

class AuthorizationUseCaseImpl(
    private val authorizationGateway: AuthorizationGateway
) : AuthorizationUseCase {

    override suspend fun checkUser(): RetrofitState {
        val result = authorizationGateway.login()
        result.body()?.let {
            return OK(it)
        }
        result.errorBody()?.let {
            if (it.string().contains(HttpStatusCodes.Unauthorized)) {
                return Unauthorized
            }
        }
        return ClientError
    }

}