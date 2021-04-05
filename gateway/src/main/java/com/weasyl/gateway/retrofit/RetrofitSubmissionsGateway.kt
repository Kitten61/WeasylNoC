package com.weasyl.gateway.retrofit

import com.weasyl.domain.entities.*
import com.weasyl.domain.gateways.SubmissionsGateway
import com.weasyl.gateway.Api
import org.jsoup.Jsoup

class RetrofitSubmissionsGateway(
    val api: Api
) : SubmissionsGateway {

    override suspend fun getUserGalleryAsync(
        username: String,
        nextId: Int
    ) = api.getUserSubmissionsAsync(username = username, nextId = nextId)

    override suspend fun getUserFavoritesAsync(
        userId: Int,
        nextId: Int
    ): PaginationResponseEntity<SubmissionEntity> {

        val a = Jsoup.connect("https://www.weasyl.com/favorites?userid=${userId}&feature=submit&nextid=${nextId}").header("X-Weasyl-Api-Key", "2ELPn53uZSonqibNSy8QF8aKUs7AJq5nhD1ZNMuEk9IRRqud").get()
        val response =
            a.body().getElementsByClass("item").map {
                val src = it.getElementsByClass("has-space").attr("src")
                val title = it.getElementsByTag("h6").attr("title")
                val login = it.getElementsByClass("username").attr("href").substringAfter("/~")
                val rating = it.getElementsByTag("span").firstOrNull()?.attr("class")
                    ?.substringAfter("rating ") ?: "general"
                val username = it.getElementsByClass("username").text()
                val id = it.getElementsByClass("thumb-bounds").attr("href").split("/")[3].toInt()
                SubmissionEntity(
                    rating = rating,
                    tags = null,
                    owner = username,
                    ownerLogin = login,
                    id = id,
                    title = title,
                    media = SubmissionMediaEntity(
                        thumbnailGenerated = listOf(),
                        cover = listOf(MediaEntity(id = 0, url = src))
                    ),
                    postDate = "",
                    ownerMedia = UserMediaEntity(avatar = listOf(), banner = listOf())
                )
            }

        return PaginationResponseEntity(response, response.lastOrNull()?.id)
    }


    override suspend fun getSubmissionInfoAsync(submitId: Int) =
        api.getSubmissionAsync(submitId = submitId)

}