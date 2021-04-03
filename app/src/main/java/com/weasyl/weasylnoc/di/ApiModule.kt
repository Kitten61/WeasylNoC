package com.weasyl.weasylnoc.di

import com.weasyl.gateway.Api
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [RetrofitModule::class])
class ApiModule {

    @Provides
    @Singleton
    fun provideScriptApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }

}

