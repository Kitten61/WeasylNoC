package com.weasyl.domain.usecases

import com.weasyl.domain.entities.UserEntity
import com.weasyl.domain.entities.UserLogonEntity
import com.weasyl.domain.gateways.AuthorizationGateway
import com.weasyl.domain.gateways.UserGateway
import com.weasyl.domain.usecases.user.UserDataUseCase

class UserDataUseCaseImp(
    private val userDataGateway: UserGateway
) : UserDataUseCase {

    override suspend fun getUserData(username: String): UserEntity? {
        return userDataGateway.getUserDataAsync(username).await().body()
    }

    override suspend fun getCurrentUser(): UserLogonEntity? {
        return userDataGateway.getCurrentUserAsync().await().body()
    }

    override suspend fun getSelfUserData(): UserEntity? {
        return getUserData(getCurrentUser()?.login.toString())
    }


}