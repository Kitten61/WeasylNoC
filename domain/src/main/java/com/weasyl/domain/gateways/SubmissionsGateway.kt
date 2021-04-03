package com.weasyl.domain.gateways

import com.weasyl.domain.entities.PaginationResponseEntity
import com.weasyl.domain.entities.SubmissionEntity
import com.weasyl.domain.entities.UserEntity
import kotlinx.coroutines.Deferred
import retrofit2.Response

interface SubmissionsGateway {

    suspend fun getUserGalleryAsync(username: String, nextId: Int) : Deferred<Response<PaginationResponseEntity<SubmissionEntity>>>

}