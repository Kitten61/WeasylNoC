package com.weasyl.domain.usecases.user

import com.weasyl.domain.entities.UserEntity
import com.weasyl.domain.entities.UserLogonEntity

interface UserDataUseCase {

    suspend fun getUserData(username: String) : UserEntity?
    suspend fun getCurrentUser() : UserLogonEntity?
    suspend fun getSelfUserData() : UserEntity?
    suspend fun getUserId(username: String?): Int

}