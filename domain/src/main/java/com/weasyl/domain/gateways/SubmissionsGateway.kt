package com.weasyl.domain.gateways

import com.weasyl.domain.entities.PaginationResponseEntity
import com.weasyl.domain.entities.SubmissionEntity
import kotlinx.coroutines.Deferred
import retrofit2.Response

interface SubmissionsGateway {

    suspend fun getUserGalleryAsync(username: String, nextId: Int) : Deferred<Response<PaginationResponseEntity<SubmissionEntity>>>

    suspend fun getUserFavoritesAsync(
        userId: Int,
        nextId: Int
    ): PaginationResponseEntity<SubmissionEntity>

    suspend fun getSubmissionInfoAsync(submitId: Int) : Deferred<Response<SubmissionEntity>>

}