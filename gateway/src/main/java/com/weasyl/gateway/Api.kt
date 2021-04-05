package com.weasyl.gateway

import com.weasyl.domain.constants.ApiConst.Companion.COUNT_PER_PAGE
import com.weasyl.domain.constants.SharedPreferencesConst.Companion.API_KEY_HEADER
import com.weasyl.domain.entities.PaginationResponseEntity
import com.weasyl.domain.entities.SubmissionEntity
import com.weasyl.domain.entities.UserEntity
import com.weasyl.domain.entities.UserLogonEntity
import io.reactivex.Single
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*


interface Api {

    @GET("/api/whoami")
    fun whoAmIAsync(): Deferred<Response<UserLogonEntity>>

    @GET("/api/users/{username}/view")
    fun getUserAsync(@Path("username") username: String): Deferred<Response<UserEntity>>

    @GET("/api/users/{username}/gallery")
    fun getUserSubmissionsAsync(
        @Path("username") username: String,
        @Query("count") count: Int = COUNT_PER_PAGE,
        @Query("nextid") nextId: Int?
    ): Deferred<Response<PaginationResponseEntity<SubmissionEntity>>>

    @GET("/api/submissions/{submitId}/view")
    fun getSubmissionAsync(
        @Path("submitId") submitId: Int
    ): Deferred<Response<SubmissionEntity>>

    @POST("/api/submissions/{submitid}/favorite")
    fun setFavAsync(
        @Path("submitid") submitId: Int
    )

    @POST("/api/submissions/{submitid}/unfavorite")
    fun setUnFavAsync(
        @Path("submitid") submitId: Int
    )

}