package com.findapple.findapple.data.features.comment.remote

import com.findapple.findapple.data.dto.response.CommentResponse
import com.findapple.findapple.data.features.comment.dto.request.PostCommentRequest
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CommentApi {
    @GET("{commentType}/{id}")
    fun getComments(@Path("commentType")commentType: String, @Path("id")id: Long): Single<List<CommentResponse>>

    @POST("{commentType}/{id}")
    fun postComments(@Path("commentType") commentType: String, @Path("id") id: Long, @Body request: PostCommentRequest): Single<Unit>
}