package com.weasyl.gateway.retrofit

import com.weasyl.domain.entities.*
import com.weasyl.domain.gateways.UserGateway
import com.weasyl.gateway.Api
import kotlinx.coroutines.Deferred
import org.jsoup.Jsoup
import retrofit2.Response

class RetrofitUserGateway(
    private val api: Api
) : UserGateway {

    override suspend fun getUserDataAsync(username: String) = api.getUserAsync(username)
    override suspend fun getCurrentUserAsync(): Deferred<Response<UserLogonEntity>> = api.whoAmIAsync()

    override suspend fun getUserId(username: String?): Int {
        val a = Jsoup.connect("https://www.weasyl.com/favorites/${username}").get()
        val userId = a.getElementsByClass("thumbnail-grid").first().getElementsByClass("more").attr("href").substringAfter("/favorites?userid=").substringBefore("&").toInt()

        return userId
    }

}