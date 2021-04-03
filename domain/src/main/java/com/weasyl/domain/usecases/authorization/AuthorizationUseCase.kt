package com.weasyl.domain.usecases.authorization

import com.weasyl.domain.enums.RetrofitState

interface AuthorizationUseCase {

    suspend fun checkUser(): RetrofitState

}