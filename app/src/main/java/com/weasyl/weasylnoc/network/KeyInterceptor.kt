package com.weasyl.weasylnoc.network

import android.content.Context
import android.content.SharedPreferences
import com.weasyl.domain.constants.SharedPreferencesConst
import com.weasyl.domain.constants.SharedPreferencesConst.Companion.API_KEY
import com.weasyl.domain.constants.SharedPreferencesConst.Companion.API_KEY_HEADER
import com.weasyl.weasylnoc.App
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class KeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val apiKey = App.preferences.getString(API_KEY, "") ?: ""
        return chain.proceed(
            chain.request()
                .newBuilder()
                .addHeader(API_KEY_HEADER, apiKey)
                .build()
        )
    }

}