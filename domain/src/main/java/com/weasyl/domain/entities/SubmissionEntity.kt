package com.weasyl.domain.entities

import com.google.gson.annotations.SerializedName

data class SubmissionEntity(
    val rating: String,
    val tags: List<String>?,
    val link: String,
    @SerializedName("owner")
    val owner: String,
    @SerializedName("owner_login")
    val ownerLogin: String,
    @SerializedName("submitid")
    val id: Int,
    val title: String,
    val media: SubmissionMediaEntity,
    @SerializedName("posted_at")
    val postDate: String
)