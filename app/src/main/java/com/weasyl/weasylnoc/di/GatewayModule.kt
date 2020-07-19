package com.weasyl.weasylnoc.di

import com.weasyl.domain.gateways.AuthorizationGateway
import com.weasyl.gateway.Api
import com.weasyl.gateway.retrofit.RetrofitAuthorizationGateway
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ApiModule::class])
class GatewayModule {
    @Provides
    @Singleton
    fun provideAuthorizationGateway(api: Api): AuthorizationGateway {
        return RetrofitAuthorizationGateway(api)
    }
}
