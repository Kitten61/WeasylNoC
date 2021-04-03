package com.weasyl.domain.entities

import com.google.gson.annotations.SerializedName

data class UserEntity(

    @SerializedName("full_name")
    val fullName: String,

    val username: String,

    @SerializedName("show_favorites_tab")
    val showFavoritesTab: Boolean,

    val media: UserMediaEntity
)