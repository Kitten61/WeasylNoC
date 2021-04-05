package com.weasyl.domain.entities

import com.squareup.moshi.Json

data class SubmissionEntity(
    val rating: String,
    val tags: List<String>?,
    val owner: String,
    @field:Json(name = "owner_login")
    val ownerLogin: String,
    @field:Json( name = "submitid")
    val id: Int,
    val title: String,
    val media: SubmissionMediaEntity,
    @field:Json( name = "posted_at")
    val postDate: String,
    @field:Json( name = "owner_media")
    val ownerMedia: UserMediaEntity
)