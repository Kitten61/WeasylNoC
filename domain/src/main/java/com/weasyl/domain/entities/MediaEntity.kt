package com.weasyl.domain.entities

import com.google.gson.annotations.SerializedName

data class MediaEntity(
    @SerializedName("mediaid")
    val id: Int?,

    val url: String
)