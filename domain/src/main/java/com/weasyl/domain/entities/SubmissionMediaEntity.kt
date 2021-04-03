package com.weasyl.domain.entities

import com.google.gson.annotations.SerializedName

data class SubmissionMediaEntity(
    @SerializedName("thumbnail-generated")
    val thumbnailGenerated: List<MediaEntity>,

    val cover: List<MediaEntity>

)