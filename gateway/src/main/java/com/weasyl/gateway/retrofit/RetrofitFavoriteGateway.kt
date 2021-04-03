package com.weasyl.gateway.retrofit

import com.weasyl.domain.entities.PaginationResponseEntity
import com.weasyl.domain.entities.SubmissionEntity
import com.weasyl.domain.gateways.FavoriteGateway
import com.weasyl.gateway.Api
import kotlinx.coroutines.Deferred
import retrofit2.Response

class RetrofitFavoriteGateway(
    val api: Api
) : FavoriteGateway {

    override suspend fun setFavoriteAsync(submitId: Int, isFavorite: Boolean) {
        when (isFavorite) {
            true -> api.setFavAsync(submitId)
            false -> api.setUnFavAsync(submitId)
        }
    }

}