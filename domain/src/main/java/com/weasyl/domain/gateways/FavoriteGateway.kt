package com.weasyl.domain.gateways

import com.weasyl.domain.entities.PaginationResponseEntity
import com.weasyl.domain.entities.SubmissionEntity
import kotlinx.coroutines.Deferred
import retrofit2.Response

interface FavoriteGateway {

    suspend fun setFavoriteAsync(submitId: Int, isFavorite: Boolean)

}