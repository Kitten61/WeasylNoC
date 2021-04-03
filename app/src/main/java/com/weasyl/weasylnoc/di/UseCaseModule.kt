package com.weasyl.weasylnoc.di

import com.weasyl.domain.gateways.AuthorizationGateway
import com.weasyl.domain.gateways.SubmissionsGateway
import com.weasyl.domain.gateways.UserGateway
import com.weasyl.domain.usecases.AuthorizationUseCaseImpl
import com.weasyl.domain.usecases.SubmissionUseCaseImpl
import com.weasyl.domain.usecases.UserDataUseCaseImp
import com.weasyl.domain.usecases.authorization.AuthorizationUseCase
import com.weasyl.domain.usecases.submission.SubmissionUseCase
import com.weasyl.domain.usecases.user.UserDataUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [GatewayModule::class])
class UseCaseModule {

    @Provides
    @Singleton
    fun provideAuthorizationUseCase(authorizationGateway: AuthorizationGateway): AuthorizationUseCase {
        return AuthorizationUseCaseImpl(authorizationGateway)
    }

    @Provides
    @Singleton
    fun provideUserDataUseCase(userGateway: UserGateway): UserDataUseCase {
        return UserDataUseCaseImp(userGateway)
    }

    @Provides
    @Singleton
    fun provideSubmissionsUseCase(submissionsGateway: SubmissionsGateway): SubmissionUseCase {
        return SubmissionUseCaseImpl(submissionsGateway)
    }


}