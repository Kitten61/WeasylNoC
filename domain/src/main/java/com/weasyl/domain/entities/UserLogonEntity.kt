package com.weasyl.domain.entities

data class UserLogonEntity(
    val login: String,
    val userid: Int = 0
)