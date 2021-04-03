package com.weasyl.domain.usecases.submission

import com.weasyl.domain.entities.PaginationResponseEntity
import com.weasyl.domain.entities.SubmissionEntity

interface SubmissionUseCase {

    suspend fun getSubmissions(username: String, nextId: Int): PaginationResponseEntity<SubmissionEntity>

}