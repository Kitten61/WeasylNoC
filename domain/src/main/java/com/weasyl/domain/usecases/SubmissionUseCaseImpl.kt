package com.weasyl.domain.usecases

import com.weasyl.domain.entities.PaginationResponseEntity
import com.weasyl.domain.entities.SubmissionEntity
import com.weasyl.domain.gateways.SubmissionsGateway
import com.weasyl.domain.usecases.submission.SubmissionUseCase

class SubmissionUseCaseImpl(
    private val submissionsGateway: SubmissionsGateway
) : SubmissionUseCase {

    override suspend fun getSubmissions(
        username: String,
        nextId: Int
    ): PaginationResponseEntity<SubmissionEntity> = submissionsGateway.getUserGalleryAsync(username, nextId).await().body()!!

    override suspend fun getFavoriteSubmissions(
        userId: Int,
        nextId: Int
    ): PaginationResponseEntity<SubmissionEntity> = submissionsGateway.getUserFavoritesAsync(userId, nextId)

    override suspend fun getSubmission(
        submitId: Int
    ): SubmissionEntity = submissionsGateway.getSubmissionInfoAsync(submitId).await().body()!!

}