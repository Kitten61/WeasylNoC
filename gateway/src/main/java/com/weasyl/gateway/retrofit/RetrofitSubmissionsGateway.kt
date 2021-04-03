package com.weasyl.gateway.retrofit

import com.weasyl.domain.gateways.SubmissionsGateway
import com.weasyl.gateway.Api

class RetrofitSubmissionsGateway(
    val api: Api
) : SubmissionsGateway {

    override suspend fun getUserGalleryAsync(
        username: String,
        nextId: Int
    ) = api.getUserSubmissionsAsync(username = username, nextId = nextId)

}