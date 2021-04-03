package com.weasyl.weasylnoc.di

import com.weasyl.domain.gateways.AuthorizationGateway
import com.weasyl.domain.gateways.FavoriteGateway
import com.weasyl.domain.gateways.SubmissionsGateway
import com.weasyl.domain.gateways.UserGateway
import com.weasyl.gateway.Api
import com.weasyl.gateway.retrofit.RetrofitAuthorizationGateway
import com.weasyl.gateway.retrofit.RetrofitFavoriteGateway
import com.weasyl.gateway.retrofit.RetrofitSubmissionsGateway
import com.weasyl.gateway.retrofit.RetrofitUserGateway
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [ApiModule::class])
class GatewayModule {

    @Provides
    @Singleton
    fun provideAuthorizationGateway(api: Api): AuthorizationGateway =
        RetrofitAuthorizationGateway(api)

    @Provides
    @Singleton
    fun provideUserGateway(api: Api): UserGateway =
        RetrofitUserGateway(api)

    @Provides
    @Singleton
    fun provideSubmissionsGateway(api: Api): SubmissionsGateway =
        RetrofitSubmissionsGateway(api)

    @Provides
    @Singleton
    fun provideFavoriteGateway(api: Api): FavoriteGateway =
        RetrofitFavoriteGateway(api)

}
