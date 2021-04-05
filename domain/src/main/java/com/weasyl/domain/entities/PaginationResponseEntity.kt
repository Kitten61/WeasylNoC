package com.weasyl.domain.entities

import com.google.gson.annotations.SerializedName

data class PaginationResponseEntity<T>(
    val submissions: List<T>,
    val nextid: Int?
)